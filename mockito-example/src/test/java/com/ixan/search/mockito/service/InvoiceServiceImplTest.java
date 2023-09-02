package com.ixan.search.mockito.service;

import com.ixan.search.mockito.dao.InvoiceServiceDao;
import com.ixan.search.mockito.domain.AccountPayHold;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InvoiceServiceImplTest {
	@InjectMocks
	private InvoiceServiceImpl invoiceService;
	@Mock
	private InvoiceServiceDao invoiceServiceDao;

	private static int count = 0;

	/**
	 * org.junit.Before 方法会在每次执行单元测试(org.junit.Test)时都会执行
	 * MockitoAnnotations.openMocks(this) 每次初始化的对象都是新的，可以通过地址值进行观察
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		System.out.println("run:" + (count++) + " InvoiceServiceImpl:" + invoiceService);
	}

	@Test
	public void getAllOpenInvoiceId() {
		Mockito.when(invoiceServiceDao.getAllOpenInvoiceId()).thenReturn(new ArrayList<AccountPayHold>());
		List<AccountPayHold> result = invoiceService.getAllOpenInvoiceId();
		assertEquals(0, result.size());

		Mockito.reset(invoiceServiceDao);
		Mockito.when(invoiceServiceDao.getAllOpenInvoiceId()).thenReturn(Collections.singletonList(new AccountPayHold(200, 25)));
		result = invoiceService.getAllOpenInvoiceId();
		assertEquals(1, result.size());
	}

	@Test(expected = RuntimeException.class)
	public void getAllOpenInvoiceId_error() {
		Mockito.when(invoiceServiceDao.getAllOpenInvoiceId()).thenThrow(new RuntimeException());
		invoiceService.getAllOpenInvoiceId();
	}
}