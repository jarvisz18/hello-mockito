package com.ixan.search.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/11 上午10:58
 * @description spy方式生成mock对象
 */
@SuppressWarnings("_all")
public class MockListExample02 {

	private final List<String> mockedList = spy(ArrayList.class);

	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void test_method_effect() {
		mockedList.add("Jarvis");
		Assert.assertEquals(1, mockedList.size());
	}

	@Test
	public void test_method_call_times() {
		mockedList.add("one");
		mockedList.add("two");
		verify(mockedList, times(2)).add(anyString());
		verify(mockedList, atLeast(1)).add(anyString());
		verify(mockedList, atMost(2)).add(anyString());
	}

	// 验证方法被调用
	@Test
	public void test_method_call() {
		mockedList.add("one");
		mockedList.clear();
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}
}
