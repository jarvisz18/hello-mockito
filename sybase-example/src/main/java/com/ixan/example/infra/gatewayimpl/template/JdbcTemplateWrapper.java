package com.ixan.example.infra.gatewayimpl.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
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

	/**
	 * 使用jdbcTemplate
	 */
	public Integer countIdGreaterThan(Integer idMin) {
		return jdbcTemplate.execute((CallableStatementCreator) connection -> {
			String storedProc = "{call sp_test (?,?)}";
			CallableStatement cs = connection.prepareCall(storedProc);
			// 设置输入参数的值
			cs.setInt(1, idMin);
			// 注册输出参数的类型
			cs.registerOutParameter(2, Types.INTEGER);
			return cs;
		}, callableStatement -> {
			callableStatement.execute();
			return callableStatement.getInt(2);
		});
	}

	/**
	 * 使用jdbc执行
	 */
	public Integer countIdGreaterThanByJdbc(Integer idMin) {
		DataSource dataSource = jdbcTemplate.getDataSource();
		if (dataSource != null) {
			try (Connection connection = dataSource.getConnection();
				 CallableStatement callableStatement = connection.prepareCall("call sp_test (?,?)");) {
				callableStatement.setInt(1, idMin);
				callableStatement.registerOutParameter(2, Types.INTEGER);
				callableStatement.execute();
				return callableStatement.getInt(2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
}
