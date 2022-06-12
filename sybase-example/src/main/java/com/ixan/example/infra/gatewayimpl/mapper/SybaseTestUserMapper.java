package com.ixan.example.infra.gatewayimpl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ixan.example.domain.CountValueDTO;
import com.ixan.example.domain.SybaseTestUser;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/11 下午10:42
 * @description SybaseTestUserMapper
 */
@Repository
public interface SybaseTestUserMapper extends BaseMapper<SybaseTestUser> {
	void countIdGreaterThan(CountValueDTO countValueDTO);
}
