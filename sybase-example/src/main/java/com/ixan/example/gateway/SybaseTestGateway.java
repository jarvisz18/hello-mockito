package com.ixan.example.gateway;

import com.ixan.example.domain.CountValueDTO;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/12 下午6:09
 * @description Sybase服务网关
 */
public interface SybaseTestGateway {
	CountValueDTO countIdGreaterThan(CountValueDTO countValueDTO);
}
