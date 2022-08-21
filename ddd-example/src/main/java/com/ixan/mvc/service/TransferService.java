package com.ixan.mvc.service;


import com.ixan.mvc.domain.Result;

import java.math.BigDecimal;

public interface TransferService {
	Result transfer(Long userId, String targetAccountNumber, BigDecimal amount, String cny);
}
