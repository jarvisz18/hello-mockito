package com.ixan.example.test;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.TimeZone;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/13 下午9:41
 * @description zoned date time test
 */
public class ZonedDateTimeTest {
	private String timePattern = "yyyy-MM-dd'T'HH:mm:ssZ";
	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(timePattern);
	private ZoneId losAngelesZoneId = ZoneId.of("America/Los_Angeles");
	private ZoneId beiJingZoneId = ZoneId.of("Asia/Shanghai");

	@Test
	void transTimeZone() {
		String dateTimeStr1 = "2019-05-05T22:48:52+0800";
		String dateTimeStr2 = "2019-05-05T22:48:52+0700";
		// String -> ZoneDateTime
		ZonedDateTime zonedDateTime1 =
				ZonedDateTime.parse(dateTimeStr1, dateTimeFormatter);
		// 输出 2019-05-05T22:48:52+08:00
		System.out.println(zonedDateTime1);
		ZonedDateTime zonedDateTime2 =
				ZonedDateTime.parse(dateTimeStr2, dateTimeFormatter);
		// 输出 2019-05-05T22:48:52+07:00
		System.out.println(zonedDateTime2);

		// 1. ZoneDateTime(+0800) -> ZoneDateTime(-0800) 时间会会根据时区+/-
		ZonedDateTime losAngelesZonedDateTime1 =
				zonedDateTime1.withZoneSameInstant(losAngelesZoneId);
		// 1.1 输出 2019-05-05T07:48:52-07:00[America/Los_Angeles]
		System.out.println(losAngelesZonedDateTime1);

		ZonedDateTime losAngelesZonedDateTime2 =
				zonedDateTime2.withZoneSameInstant(losAngelesZoneId);
		// 1.2 输出 2019-05-05T08:48:52-07:00[America/Los_Angeles]
		System.out.println(losAngelesZonedDateTime2);

		// 2. ZoneDateTime(+0800) -> ZoneDateTime(-0800) 时间不变，只改变时区
		ZonedDateTime result = zonedDateTime1.withZoneSameLocal(beiJingZoneId);
		// 输出 2019-05-05T22:48:52+08:00[Asia/Shanghai]
		System.out.println(result);
	}

	@Test
	void test_zoned_datetime() {
		String time = "2022-06-14T21:42:00.145-0700";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		ZonedDateTime zonedDateTime = ZonedDateTime.parse(time, formatter);
		System.out.println(zonedDateTime);
		System.out.println(zonedDateTime.toLocalDateTime());
	}

	@Test
	void test_zoned() {
		Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
		//availableZoneIds.forEach(System.out::println);
		System.out.println("=========================>");
		System.out.println(availableZoneIds.contains("+0800"));
		System.out.println(ZoneId.SHORT_IDS.containsKey("+0800"));
		System.out.println(ZoneId.of("+0800"));
	}
}
