package com.ixan.transfer.domain.aggregate.service;

import org.springframework.stereotype.Service;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2023/9/10 20:07
 * @description GrantTypeService
 */
@Service
public class GrantTypeService {
	public String redPaper(String resourceId) {
		//红包的发放方式
		return "每周末9点发放";
	}

	public String shopping(String resourceId) {
		//购物券的发放方式
		return "每周三9点发放";
	}

	public String QQVip(String resourceId) {
		//qq会员的发放方式
		return "每周一0点开始秒杀";
	}

	public String takeoutVip(String resourceType) {
		//外卖会员的发放方式
		return "每周四0点开始秒杀";
	}
}
