package com.ixan.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2022/6/11 下午10:40
 * @description mybatis plus config
 */
@Configuration
@MapperScan("com.ixan.example.mapper")
public class MybatisPlusConfig {
}
