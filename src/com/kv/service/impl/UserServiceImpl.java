package com.kv.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kv.mapper.UserMapper;
import com.kv.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserMapper mapper;
	


}
