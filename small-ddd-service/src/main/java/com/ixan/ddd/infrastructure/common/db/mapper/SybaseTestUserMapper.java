package com.ixan.ddd.infrastructure.common.db.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ixan.ddd.domain.aggregate.entity.valueobject.CountValueDTO;
import com.ixan.ddd.domain.aggregate.entity.valueobject.SybaseTestUser;
import org.springframework.stereotype.Repository;

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
