package com.ixan.search.mockito.controller;

import com.ixan.search.mockito.domain.AccountPayHold;
import com.ixan.search.mockito.service.InvoiceService;

import java.util.List;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2023/9/2 15:50
 * @description invoice controller
 */
public class InvoiceController {
	private final InvoiceService invoiceService;

	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	public List<AccountPayHold> getInvIds() {
		return invoiceService.getAllOpenInvoiceId();
	}
}
