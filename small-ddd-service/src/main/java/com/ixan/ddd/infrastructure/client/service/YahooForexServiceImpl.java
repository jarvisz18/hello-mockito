package com.ixan.ddd.infrastructure.client.service;

import com.ixan.ddd.application.service.query.YahooForexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author stackzhang@126.com
 * @date Created in 2022/8/1 10:05 PM
 * @description
 */
@Slf4j
@Service
public class YahooForexServiceImpl implements YahooForexService {
	@Override
	public BigDecimal getExchangeRate(String currency, String targetCurrency) {
		return null;
	}
}
