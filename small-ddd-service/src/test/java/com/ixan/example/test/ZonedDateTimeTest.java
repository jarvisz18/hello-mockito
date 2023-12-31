package com.ixan.example.test;


import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/13 下午9:41
 * @description zoned date time test
 * <p>
 * 参考学习文档:
 * https://docs.oracle.com/javase/10/docs/api/java/time/format/DateTimeFormatter.html
 * https://segmentfault.com/a/1190000041573835
 * https://www.concretepage.com/java/java-8/java-datetimeformatter
 * https://zhuanlan.zhihu.com/p/149302250
 */
public class ZonedDateTimeTest {
	private String timePattern = "yyyy-MM-dd'T'HH:mm:ssZ";
	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(timePattern);
	private ZoneId losAngelesZoneId = ZoneId.of("America/Los_Angeles");
	private ZoneId beiJingZoneId = ZoneId.of("Asia/Shanghai");

	@Test
	public void transTimeZone() {
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
	public void test_zoned_datetime() {
		String time = "2022-06-14T21:42:00.145-0700";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		ZonedDateTime zonedDateTime = ZonedDateTime.parse(time, formatter);
		System.out.println(zonedDateTime);
		System.out.println(zonedDateTime.toLocalDateTime());
	}

	@Test
	public void test_zoned() {
		//获得所有可用时区
		Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
		availableZoneIds.forEach(System.out::println);
		System.out.println("=========================>");
		System.out.println(availableZoneIds.contains("+0800"));
		System.out.println(ZoneId.SHORT_IDS.containsKey("+0800"));
		System.out.println(ZoneId.of("+0800"));
	}

	@Test
	public void test_print_datetime() {
		LocalDate localDate = LocalDate.now();
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println(localDate.format(DateTimeFormatter.ISO_DATE));
		System.out.println(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(zonedDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE));
		System.out.println(zonedDateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
		System.out.println(zonedDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
	}

	@Test
	public void test_zoned_time() {
		String format = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		System.out.println(formatter.format(zonedDateTime));

		//切换时区
		ZonedDateTime zoneSameInstant = zonedDateTime.withZoneSameInstant(ZoneId.of("America/Cayenne"));
		System.out.println(zonedDateTime);
		System.out.println(zoneSameInstant);
	}
}
