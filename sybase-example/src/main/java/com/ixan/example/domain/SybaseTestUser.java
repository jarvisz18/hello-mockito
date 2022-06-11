package com.ixan.example.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/11 下午10:44
 * @description SybaseTestUser
 */
@Data
@TableName(value = "tb_test_user")
public class SybaseTestUser {
	/**
	 * CREATE TABLE guest.dbo.tb_test_user (
	 * id varchar(100) NULL,
	 * username varchar(100) NULL,
	 * password varchar(100) NULL,
	 * name varchar(100) NULL,
	 * bz varchar(100) NULL
	 * );
	 */
	@TableId("id")
	private String id;
	@TableField("username")
	private String username;
	@TableField("password")
	private String password;
	@TableField("name")
	private String name;
	@TableField("bz")
	private String bz;
}
