package com.ixan.ddd.infrastructure.gatewayimpl;


import com.ixan.ddd.application.gateway.SybaseTestGateway;
import com.ixan.ddd.domain.aggregate.entity.valueobject.CountValueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/12 下午6:18
 * @description
 */
@Component("sybaseTestGatewayTemplateImpl")
public class SybaseTestGatewayTemplateImpl implements SybaseTestGateway {
	@Autowired
	private JdbcTemplateWrapper jdbcTemplateWrapper;

	@Override
	public CountValueDTO countIdGreaterThan(CountValueDTO countValueDTO) {
		Integer value = jdbcTemplateWrapper.countIdGreaterThanByJdbc(countValueDTO.getMinId());
		countValueDTO.setCountNo(value);
		return countValueDTO;
	}
}
