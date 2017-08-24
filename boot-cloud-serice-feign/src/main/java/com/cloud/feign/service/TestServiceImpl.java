package com.cloud.feign.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class TestServiceImpl implements TestService {

	@Override
	public String getName(@RequestParam("name")String name) {
		return "你得到是一个错误的名字 : " + name;
	}

}
