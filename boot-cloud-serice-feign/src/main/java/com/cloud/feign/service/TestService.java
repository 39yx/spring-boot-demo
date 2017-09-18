package com.cloud.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "shana",fallback = TestServiceImpl.class)
//@FeignClient(value = "shana")
@RequestMapping("/test")
public interface TestService {
	@RequestMapping("/getName")
	String getName(@RequestParam("name")String name,@RequestParam(value = "sleep",defaultValue = "1",required = false) Long sleep);
}
