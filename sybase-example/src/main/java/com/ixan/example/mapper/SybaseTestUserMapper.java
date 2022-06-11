package com.ixan.example.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ixan.example.domain.SybaseTestUser;
import org.springframework.stereotype.Repository;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/11 下午10:42
 * @description SybaseTestUserMapper
 */
@Repository
@DS("sybase-db")
public interface SybaseTestUserMapper extends BaseMapper<SybaseTestUser> {
}
