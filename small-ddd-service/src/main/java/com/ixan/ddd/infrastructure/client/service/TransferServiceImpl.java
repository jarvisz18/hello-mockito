package com.ixan.ddd.infrastructure.client.service;


import com.ixan.ddd.application.service.query.TransferService;
import com.ixan.ddd.application.service.query.YahooForexService;
import com.ixan.ddd.domain.aggregate.entity.AccountDO;
import com.ixan.ddd.domain.aggregate.entity.DailyLimitExceededException;
import com.ixan.ddd.domain.aggregate.entity.InsufficientFundsException;
import com.ixan.ddd.domain.aggregate.entity.InvalidCurrencyException;
import com.ixan.ddd.domain.aggregate.entity.Result;
import com.ixan.ddd.infrastructure.common.db.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RequiredArgsConstructor
@Slf4j
@Service
public class TransferServiceImpl implements TransferService {
	private static final String TOPIC_AUDIT_LOG = "TOPIC_AUDIT_LOG";
	private final AccountMapper accountDAO;
	//private KafkaTemplate<String, String> kafkaTemplate;
	private final YahooForexService yahooForex;

	@Override
	public Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) {
		// 1. 从数据库读取数据，忽略所有校验逻辑如账号是否存在等
		AccountDO sourceAccountDO = accountDAO.selectByUserId(sourceUserId);
		AccountDO targetAccountDO = accountDAO.selectByAccountNumber(targetAccountNumber);

		// 2. 业务参数校验
		if (!targetAccountDO.getCurrency().equals(targetCurrency)) {
			throw new InvalidCurrencyException();
		}

		// 3. 获取外部数据，并且包含一定的业务逻辑
		// exchange rate = 1 source currency = X target currency
		BigDecimal exchangeRate = BigDecimal.ONE;
		if (sourceAccountDO.getCurrency().equals(targetCurrency)) {
			exchangeRate = yahooForex.getExchangeRate(sourceAccountDO.getCurrency(), targetCurrency);
		}
		BigDecimal sourceAmount = targetAmount.divide(exchangeRate, RoundingMode.DOWN);

		// 4. 业务参数校验
		if (sourceAccountDO.getAvailable().compareTo(sourceAmount) < 0) {
			throw new InsufficientFundsException();
		}

		if (sourceAccountDO.getDailyLimit().compareTo(sourceAmount) < 0) {
			throw new DailyLimitExceededException();
		}

		// 5. 计算新值，并且更新字段
		BigDecimal newSource = sourceAccountDO.getAvailable().subtract(sourceAmount);
		BigDecimal newTarget = targetAccountDO.getAvailable().add(targetAmount);
		sourceAccountDO.setAvailable(newSource);
		targetAccountDO.setAvailable(newTarget);

		// 6. 更新到数据库
		accountDAO.update(sourceAccountDO);
		accountDAO.update(targetAccountDO);

		// 7. 发送审计消息
		String message = sourceUserId + "," + targetAccountNumber + "," + targetAmount + "," + targetCurrency;
		//kafkaTemplate.send(TOPIC_AUDIT_LOG, message);

		return Result.success(true);
	}
}
