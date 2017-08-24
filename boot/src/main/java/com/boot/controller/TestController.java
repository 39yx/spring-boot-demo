package com.boot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bean.Person;
import com.boot.mapper.TestMapper;
import com.boot.service.TestService;

@RestController
@RequestMapping("test")
public class TestController {
	
	@Autowired
	private Person person;
	
	@Autowired
	private TestMapper testMapper;
	
	@Autowired
	private TestService testService;
	
	@Value("${table-name}")
	private String tableName;
	
	@GetMapping("/test1")
	public Person test1(HttpSession session) {
		//testService.add();
		person.setName(person.getName() + ",count : " + testMapper.getCount(tableName) + ",table:" +tableName);
		return person;
	}
}
