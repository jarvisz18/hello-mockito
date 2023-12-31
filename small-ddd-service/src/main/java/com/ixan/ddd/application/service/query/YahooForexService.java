package com.ixan.ddd.application.service.query;

import java.math.BigDecimal;

/**
 * @author stackzhang@126.com
 * @date Created in 2022/8/1 10:05 PM
 * @description
 */
public interface YahooForexService {
	BigDecimal getExchangeRate(String currency, String targetCurrency);
}
