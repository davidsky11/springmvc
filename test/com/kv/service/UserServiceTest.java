package com.kv.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

	@Test
	public void userServiceTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"configs/application.xml");
		IUserService userService = (IUserService) context
				.getBean("userService");
	}

}
