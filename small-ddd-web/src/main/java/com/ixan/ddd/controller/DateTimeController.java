package com.ixan.ddd.controller;

import com.ixan.ddd.domain.aggregate.entity.valueobject.ZonedDateTimeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/13 下午9:12
 * @description test javas8 datetime
 */
@RestController
public class DateTimeController {

	@GetMapping("/api/public/now")
	public ZonedDateTimeDTO testCurrentDateTime() {
		ZonedDateTimeDTO zonedDateTimeDTO = new ZonedDateTimeDTO();
		zonedDateTimeDTO.setCurrentDate(new Date());
		zonedDateTimeDTO.setLocalDateTime(LocalDateTime.now());
		zonedDateTimeDTO.setZonedDateTime(ZonedDateTime.now());
		return zonedDateTimeDTO;
	}
}
