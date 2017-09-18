package com.cloud.feign.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/test2")
public class TestServiceImpl implements TestService {

	@Override
	public String getName(String name,Long sleep) {
		return "你得到是一个错误的名字 : " + name;
	}

}
