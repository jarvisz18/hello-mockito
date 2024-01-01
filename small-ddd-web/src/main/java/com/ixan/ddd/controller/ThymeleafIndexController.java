package com.ixan.ddd.controller;

import com.ixan.ddd.domain.aggregate.entity.valueobject.UserAccountDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2024/1/1 10:32
 * @description thymeleaf test controller
 */
@Controller
public class ThymeleafIndexController {

	@RequestMapping("/account")
	public String index(Model m) {
		List<UserAccountDTO> list = new ArrayList<>();
		list.add(new UserAccountDTO("KangKang", "康康", "e10adc3949ba59abbe56e", "超级管理员", "17777777777"));
		list.add(new UserAccountDTO("Mike", "麦克", "e10adc3949ba59abbe56e", "管理员", "13444444444"));
		list.add(new UserAccountDTO("Jane", "简", "e10adc3949ba59abbe56e", "运维人员", "18666666666"));
		list.add(new UserAccountDTO("Maria", "玛利亚", "e10adc3949ba59abbe56e", "清算人员", "19999999999"));
		m.addAttribute("accountList", list);
		return "account";
	}
}
