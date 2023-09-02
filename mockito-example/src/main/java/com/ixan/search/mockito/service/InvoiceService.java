package com.ixan.search.mockito.service;

import com.ixan.search.mockito.domain.AccountPayHold;

import java.util.List;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2023/9/2 15:52
 * @description invoice service
 */
public interface InvoiceService {
	List<AccountPayHold> getAllOpenInvoiceId();
}
