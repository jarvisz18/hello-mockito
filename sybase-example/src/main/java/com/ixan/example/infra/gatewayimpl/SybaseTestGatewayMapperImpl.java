package com.ixan.example.infra.gatewayimpl;

import com.ixan.example.domain.CountValueDTO;
import com.ixan.example.gateway.SybaseTestGateway;
import com.ixan.example.infra.gatewayimpl.mapper.SybaseTestUserMapper;
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
