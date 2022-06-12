package com.ixan.example.infra.gatewayimpl.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.Types;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/12 下午6:19
 * @description JdbcTemplate wrapper
 */
@Component
public class JdbcTemplateWrapper {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Integer countIdGreaterThan(Integer id_min) {
		return jdbcTemplate.execute((CallableStatementCreator) connection -> {
			String storedProc = "{call sp_test (?,?)}";
			CallableStatement cs = connection.prepareCall(storedProc);
			// 设置输入参数的值
			cs.setInt(1, id_min);
			// 注册输出参数的类型
			cs.registerOutParameter(2, Types.INTEGER);
			return cs;
		}, callableStatement -> {
			callableStatement.execute();
			return callableStatement.getInt(2);
		});
	}
}
