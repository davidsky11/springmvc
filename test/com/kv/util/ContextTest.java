package com.kv.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.kv.model.User;
import com.kv.service.IUserService;

public class ContextTest extends JunitTestBase {
	
	@Test
	public void test() {
		System.out.println(context.getDisplayName());
		IUserService service = (IUserService) context.getBean("userSerivce");
		System.out.println("###");
		assertNotNull(service);
		
		boolean flag = service.existUser("test");
		System.out.println(flag);
		
		/*
		User user = new User();
		user.setUsername("test");
		user.setPassword("123");
		user.setNickname("测试");
		user.setEmail("test@tx.com");
		service.addUser(user);
		*/
		
	}
	
}
