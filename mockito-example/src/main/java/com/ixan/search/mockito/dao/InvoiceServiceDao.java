package com.ixan.search.mockito.dao;

import com.ixan.search.mockito.domain.AccountPayHold;

import java.util.List;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2023/9/2 16:22
 * @description InvoiceServiceDao
 */
public interface InvoiceServiceDao {
	List<AccountPayHold> getAllOpenInvoiceId();
}
