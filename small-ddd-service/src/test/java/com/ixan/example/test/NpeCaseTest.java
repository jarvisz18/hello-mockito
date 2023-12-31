package com.ixan.example.test;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2023/7/15 20:04
 * @description Objects Method Test
 */
public class NpeCaseTest {
	@Test
	public void test_objects_equals() {
		Integer num1 = 1;
		long num2 = 2L;
		System.out.println(Objects.equals(num1, num2));
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Date date = new Date(timestamp.getTime());
		System.out.println(Objects.equals(timestamp, date));
	}

	@Test
	public void test_integer_npe() {
		Integer num1 = null;
		Integer num2 = 2;
		int n1 = num1 == null ? 0 : num1;
		int n2 = num2 == null ? 0 : num2;
		System.out.println(n1 + n2);
	}

	@Test
	public void test_string_is_empty() {
		String str1 = null;
		String str2 = "TEST";
		System.out.println(StringUtils.isEmpty(str1));
		System.out.println(Objects.equals(str1,str2));
	}

	@Test
	public void test_listToMap(){
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, null));
		Map<Integer, List<Integer>> collect = list.stream()
				.filter(Objects::nonNull)
				.collect(Collectors.groupingBy(p -> p));
		System.out.println(collect);
	}

	@Test
	public void test_listToMap2() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 6, 2));
		Map<Integer, Integer> collect = list.stream()
				.filter(Objects::nonNull)
				.collect(Collectors.toMap(p -> p, Function.identity(), (key1, key2) -> key2));
		System.out.println(collect);
	}
}
