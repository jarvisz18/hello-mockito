package com.ixan.example.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/12 下午6:11
 * @description count value dto
 */
@Getter
@Setter
public class CountValueDTO {
	private Integer minId;
	private Integer countNo;

	public CountValueDTO(Integer minId) {
		if (Objects.isNull(minId)) {
			throw new RuntimeException("minId can not be null");
		}
		this.minId = minId;
	}
}
