package com.ixan.example.test;


import com.ixan.ddd.application.service.query.SybaseTestService;
import com.ixan.ddd.domain.aggregate.entity.valueobject.SybaseTestUser;
import com.ixan.ddd.infrastructure.common.db.mapper.SybaseTestUserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/11 下午10:46
 * @description TestUserAcMapperTest
 */
@SpringBootTest
public class TestUserAcMapperTest {
	@Autowired
	private SybaseTestUserMapper sybaseTestUserMapper;
	@Autowired
	private SybaseTestService sybaseTestService;

	@Test
	public void test_countIdGreaterThan() {
		Integer value = sybaseTestService.countIdGreaterThan(1);
		System.out.println(value);
	}

	// sybase 数据源测试
	@Test
	public void sybaseSelectTest() {
		List<SybaseTestUser> userList = sybaseTestUserMapper.selectList(null);
		System.out.println(userList);
	}

}
