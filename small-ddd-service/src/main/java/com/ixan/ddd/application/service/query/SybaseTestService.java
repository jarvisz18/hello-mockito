package com.ixan.ddd.application.service.query;

import com.ixan.ddd.application.gateway.SybaseTestGateway;
import com.ixan.ddd.domain.aggregate.entity.valueobject.CountValueDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/12 下午5:51
 * @description sybase test service
 */
@Service
public class SybaseTestService {
	@Resource(name = "sybaseTestGatewayTemplateImpl")
	private SybaseTestGateway sybaseTestGateway;

	public Integer countIdGreaterThan(Integer id_min) {
		CountValueDTO countValueDTO = new CountValueDTO(id_min);
		return sybaseTestGateway.countIdGreaterThan(countValueDTO).getCountNo();
	}
}
