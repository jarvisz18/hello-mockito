package com.ixan.example.test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/11 下午2:09
 * @description argument matcher example
 */
public class ArgumentMatcherExample02 {

	@Test
	public void test() {
		Foo mock = Mockito.mock(Foo.class);
		//cover大的写在前面,这样后面才能个性化配置
		when(mock.function(anyString(), anyInt(), anyCollection(), anyString())).thenReturn(-1);
		when(mock.function(eq("Jarvis"), anyInt(), anyCollection(), anyString())).thenReturn(100);
		when(mock.function(eq("Tony"), anyInt(), anyCollection(), anyString())).thenReturn(100);

		Assert.assertEquals(100, mock.function("Jarvis", 9527, Collections.emptySet(), "Mockito"));
		Assert.assertEquals(100, mock.function("Tony", 8848, Collections.emptySet(), "Mockito"));
		Assert.assertEquals(-1, mock.function("Jimmy", 4399, Collections.emptyList(), "Mockito"));
	}

	static class Foo {
		int function(String param1, int param2, Collection param3, Serializable param4) {
			return 0;
		}
	}
}
