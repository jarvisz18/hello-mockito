package com.ixan.ddd.application.service.query;



import com.ixan.ddd.domain.aggregate.entity.Result;

import java.math.BigDecimal;

public interface TransferService {
	Result transfer(Long userId, String targetAccountNumber, BigDecimal amount, String cny);
}
