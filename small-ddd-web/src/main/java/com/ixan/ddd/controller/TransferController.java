package com.ixan.ddd.controller;



import com.ixan.ddd.application.service.query.TransferService;
import com.ixan.ddd.domain.aggregate.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@RestController
public class TransferController {
	@Autowired
	private TransferService transferService;

	public Result<Boolean> transfer(String targetAccountNumber, BigDecimal amount, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		return transferService.transfer(userId, targetAccountNumber, amount, "CNY");
	}
}
