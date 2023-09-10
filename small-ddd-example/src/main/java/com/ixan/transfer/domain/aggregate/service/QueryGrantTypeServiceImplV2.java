package com.ixan.transfer.domain.aggregate.service;

import com.ixan.transfer.application.service.query.QueryGrantTypeService;
import com.ixan.transfer.infrastructure.common.enums.GrantTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author stackzhang@126.com
 * @version 1.1
 * @date Created in 2023/9/10 20:04
 * @description QueryGrantTypeServiceImpl v2
 */
@RequiredArgsConstructor
@Service("queryGrantTypeServiceImplV2")
public class QueryGrantTypeServiceImplV2 implements QueryGrantTypeService {
	private final GrantTypeService grantTypeService;
	private final Map<String, Function<String, String>> grantTypeMap = new HashMap<>();

	@PostConstruct
	public void init() {
		grantTypeMap.put(GrantTypeEnum.RED_PAPER.getValue(), grantTypeService::redPaper);
		grantTypeMap.put(GrantTypeEnum.SHOPPING.getValue(), grantTypeService::shopping);
		grantTypeMap.put(GrantTypeEnum.QQ_VIP.getValue(), grantTypeService::QQVip);
		grantTypeMap.put(GrantTypeEnum.TAKEOUT_VIP.getValue(), grantTypeService::takeoutVip);
	}

	@Override
	public String getResult(String resourceType) {
		Function<String, String> result = grantTypeMap.get(resourceType);
		if (result != null) {
			//传入resourceId 执行这段表达式获得String型的grantType
			return result.apply(resourceType);
		}
		return "查询不到该优惠券的发放方式";
	}
}
