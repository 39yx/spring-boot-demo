package com.cloud.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.feign.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	private TestService testService;

	@RequestMapping("/getName")
	public String getName(@RequestParam("name")String name) {
		return testService.getName(name);
	}
}
