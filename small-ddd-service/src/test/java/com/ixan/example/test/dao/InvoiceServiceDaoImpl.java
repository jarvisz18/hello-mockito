package com.ixan.example.test.dao;


import com.ixan.example.test.domain.AccountPayHold;

import java.util.Collections;
import java.util.List;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2023/9/2 16:23
 * @description InvoiceServiceDao impl
 */
public class InvoiceServiceDaoImpl implements InvoiceServiceDao {
	public List<AccountPayHold> getAllOpenInvoiceId() {
		return Collections.singletonList(new AccountPayHold(100, 1));
	}
}
