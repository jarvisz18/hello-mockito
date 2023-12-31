package com.ixan.example.test.dao;



import com.ixan.example.test.domain.AccountPayHold;

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
