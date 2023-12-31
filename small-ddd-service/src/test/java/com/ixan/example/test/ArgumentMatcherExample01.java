package com.ixan.example.test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/11 下午1:09
 * @description argument example matcher 01
 */
public class ArgumentMatcherExample01 {

	@Test
	public void test_any() {
		Foo foo = mock(Foo.class);
		when(foo.function(Mockito.any(Child1.class))).thenReturn(100);
		Assert.assertEquals(100, foo.function(new Child1()));
		Assert.assertEquals(100, foo.function(new Child2()));
	}

	@Test
	public void test_isA() {
		Foo foo = mock(Foo.class);
		when(foo.function(Mockito.isA(Parent.class))).thenReturn(100);
		Assert.assertEquals(100, foo.function(new Child1()));
		Assert.assertEquals(100, foo.function(new Child2()));

		reset(foo);
		when(foo.function(Mockito.isA(Child1.class))).thenReturn(100);
		Assert.assertEquals(100, foo.function(new Child1()));
		Assert.assertEquals(0, foo.function(new Child2()));
	}

	interface Parent {
	}

	static abstract class Foo {
		abstract int function(Parent p);
	}

	static class Child1 extends Foo implements Parent {
		@Override
		public int function(Parent p) {
			throw new RuntimeException();
		}
	}

	static class Child2 extends Foo implements Parent {

		@Override
		public int function(Parent p) {
			throw new RuntimeException();
		}
	}
}
