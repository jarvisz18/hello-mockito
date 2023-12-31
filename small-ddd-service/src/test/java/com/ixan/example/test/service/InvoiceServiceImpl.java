package com.ixan.example.test.service;



import com.ixan.example.test.dao.InvoiceServiceDao;
import com.ixan.example.test.domain.AccountPayHold;

import java.util.List;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2023/9/2 15:52
 * @description InvoiceService impl
 */
public class InvoiceServiceImpl implements InvoiceService {
	private final InvoiceServiceDao invoiceServiceDao;

	public InvoiceServiceImpl(InvoiceServiceDao invoiceServiceDao) {
		this.invoiceServiceDao = invoiceServiceDao;
	}

	public List<AccountPayHold> getAllOpenInvoiceId() {
		return invoiceServiceDao.getAllOpenInvoiceId();
	}
}
