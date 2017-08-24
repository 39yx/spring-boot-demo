package com.cloud.ribbon.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class TestService {
	 @Autowired
	 private RestTemplate restTemplate;
	 
	 @HystrixCommand(fallbackMethod = "error")
	 public String getName(String name) {
		 //return restTemplate.getForObject("http://KANADE/test/getName?name=" + name, String.class);
		 Map<String, String> params = new HashMap<>();
		 params.put("name", name);
		 //以下是用了负载均衡的调用方式
		 return restTemplate.getForObject("http://SHANA/test/getName?name=" + name, String.class,params);
		 //如果不用负载均衡请用详细的地址 而不是用 服务名称来调用 服务
		 //return restTemplate.getForObject("http://localhost:5555/test/getName?name=" + name, String.class,params);
	 }
	 
	 public String error(String name) {
		 return "我返回了一个错误的名字哦 : " + name;
	 }
	 
}
