package com.ixan.example.test.controller;

import com.ixan.example.test.domain.AccountPayHold;
import com.ixan.example.test.service.InvoiceService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InvoiceControllerTest {
	@InjectMocks
	private InvoiceController invoiceController;
	@Mock
	private InvoiceService invoiceService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void getInvIds() {
		Mockito.when(invoiceService.getAllOpenInvoiceId()).thenReturn(Collections.singletonList(new AccountPayHold(1041,3)));
		List<AccountPayHold> result = invoiceController.getInvIds();
		assertEquals(1, result.size());

		Mockito.reset(invoiceService);
		Mockito.when(invoiceService.getAllOpenInvoiceId()).thenReturn(Collections.<AccountPayHold>emptyList());
		result = invoiceController.getInvIds();
		assertEquals(0, result.size());
	}
}