package com.ixan.ddd.infrastructure.common.db.mapper;


import com.ixan.ddd.domain.aggregate.entity.AccountDO;
import org.springframework.stereotype.Repository;

/**
 * @author stackzhang@126.com
 * @date Created in 2022/8/1 9:38 PM
 * @description
 */
@Repository
public interface AccountMapper {
	AccountDO selectByUserId(Long sourceUserId);

	AccountDO selectByAccountNumber(String targetAccountNumber);

	void update(AccountDO sourceAccountDO);
}
