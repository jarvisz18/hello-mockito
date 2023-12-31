package com.ixan.ddd.domain.aggregate.service;

import com.ixan.ddd.application.service.query.QueryGrantTypeService;
import com.ixan.ddd.infrastructure.common.enums.GrantTypeConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2023/9/10 19:44
 * @description QueryGrantTypeService impl
 */
@RequiredArgsConstructor
@Service("queryGrantTypeServiceImpl")
public class QueryGrantTypeServiceImpl implements QueryGrantTypeService {
	private final GrantTypeService grantTypeService;


	@Override
	public String getResult(String resourceType) {
		String result = null;
		switch (resourceType) {
			case GrantTypeConstants.RED_PAPER:
				result = grantTypeService.redPaper(resourceType);
				break;
			case GrantTypeConstants.SHOPPING:
				result = grantTypeService.shopping(resourceType);
				break;
			case GrantTypeConstants.QQ_VIP:
				result = grantTypeService.QQVip(resourceType);
				break;
			case GrantTypeConstants.TAKEOUT_VIP:
				result = grantTypeService.takeoutVip(resourceType);
				break;
			default:
				throw new UnsupportedOperationException(resourceType);
		}
		return result;
	}
}
