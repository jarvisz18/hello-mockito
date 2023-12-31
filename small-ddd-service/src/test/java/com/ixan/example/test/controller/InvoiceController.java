package com.ixan.example.test.controller;

import com.ixan.example.test.domain.AccountPayHold;
import com.ixan.example.test.service.InvoiceService;

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
