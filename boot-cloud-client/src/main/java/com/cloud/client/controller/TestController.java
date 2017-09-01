package com.cloud.client.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/getName")
	public String aa(@RequestParam("name") String name,@RequestParam(value = "sleep",defaultValue = "1",required = false) Long sleep) {
		if(name.equals("aa")) {
			throw new RuntimeException("抛异常");
		}
		if(name.contains("kk")){
			try {
				TimeUnit.SECONDS.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return port + " -->你要的名字哦: " + name;
	}
}
