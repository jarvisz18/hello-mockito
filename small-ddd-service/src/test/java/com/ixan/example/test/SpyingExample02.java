package com.ixan.example.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/11 下午12:38
 * @description spying example 01
 */
public class SpyingExample02 {
	@Spy
	private List<String> spy = new ArrayList<String>();

	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void test_spying_mock() {
		spy.add("Jarvis");
		spy.add("Jack");

		Assert.assertEquals("Jarvis", spy.get(0));
		Assert.assertEquals("Jack", spy.get(1));

		when(spy.isEmpty()).thenReturn(true);
		when(spy.size()).thenReturn(0);

		Assert.assertEquals("Jarvis", spy.get(0));
		Assert.assertEquals("Jack", spy.get(1));
		Assert.assertTrue(spy.isEmpty());
		Assert.assertEquals(0, spy.size());
	}
}
