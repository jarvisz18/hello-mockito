package com.ixan.ddd.infrastructure.gatewayimpl;


import com.ixan.ddd.application.gateway.SybaseTestGateway;
import com.ixan.ddd.domain.aggregate.entity.valueobject.CountValueDTO;
import com.ixan.ddd.infrastructure.common.db.mapper.SybaseTestUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/12 下午6:13
 * @description SybaseTestGatewayImpl
 */
@Component("sybaseTestGatewayMapperImpl")
public class SybaseTestGatewayMapperImpl implements SybaseTestGateway {
	@Autowired
	private SybaseTestUserMapper sybaseTestUserMapper;

	@Override
	public CountValueDTO countIdGreaterThan(CountValueDTO countValueDTO) {
		sybaseTestUserMapper.countIdGreaterThan(countValueDTO);
		return countValueDTO;
	}
}
