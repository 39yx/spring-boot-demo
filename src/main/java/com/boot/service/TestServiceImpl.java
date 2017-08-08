package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.mapper.TestMapper;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestMapper testMapper;
	
	@Override
	@Transactional
	public void add() {
		testMapper.add("222");
		testMapper.add("222222");
	}

}
