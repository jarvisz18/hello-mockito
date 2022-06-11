package com.ixan.example.test;

import com.ixan.example.domain.SybaseTestUser;
import com.ixan.example.mapper.SybaseTestUserMapper;
import org.junit.jupiter.api.Test;
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
class TestUserAcMapperTest {
	@Autowired
	private SybaseTestUserMapper sybaseTestUserMapper;

	// sybase 数据源测试
	@Test
	void sybaseSelectTest() {
		List<SybaseTestUser> userList = sybaseTestUserMapper.selectList(null);
		System.out.println(userList);
	}

}
