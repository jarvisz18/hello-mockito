package com.ixan.mvc.domain;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author mac
 */
@Data
@Accessors(chain = true)
public class Result<T> {
	private Integer code;
	private String msg;
	private T data;

	public static <T> Result<T> success(T data) {
		Result<T> result = new Result<T>();
		result.setData(data);
		result.setCode(200);
		result.setMsg("ok");
		return result;
	}
}
