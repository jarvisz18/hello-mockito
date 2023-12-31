package com.ixan.ddd.domain.aggregate.entity;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDO {
	private String currency;
	private BigDecimal available;
	private BigDecimal dailyLimit;
}
