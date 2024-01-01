package com.ixan.ddd.domain.aggregate.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2024/1/1 10:34
 * @description user account dto
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserAccountDTO {
	private String account;
	private String name;
	private String password;
	private String accountType;
	private String tel;
}
