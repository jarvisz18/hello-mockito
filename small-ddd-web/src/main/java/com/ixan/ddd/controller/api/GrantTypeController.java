package com.ixan.ddd.controller.api;

import com.ixan.ddd.application.service.query.QueryGrantTypeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2023/9/10 19:41
 * @description GrantTypeController
 */
@RestController
public class GrantTypeController {

	@Resource(name = "queryGrantTypeServiceImplV2")
	private QueryGrantTypeService queryGrantTypeService;

	@PostMapping("/api/grantType")
	public String grantType(@RequestParam("resourceType") String resourceType) {
		return queryGrantTypeService.getResult(resourceType);
	}
}
