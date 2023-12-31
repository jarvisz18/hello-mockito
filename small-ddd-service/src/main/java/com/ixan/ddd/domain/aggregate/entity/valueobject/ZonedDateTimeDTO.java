package com.ixan.ddd.domain.aggregate.entity.valueobject;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/13 下午9:13
 * @description zoned date time dto
 */
@Data
public class ZonedDateTimeDTO implements Serializable {
	private ZonedDateTime zonedDateTime;
	private LocalDateTime localDateTime;
	private Date currentDate;
}
