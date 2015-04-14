package com.kv.util;

import org.junit.Before;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>Title: FSVM System</p>
 *
 * <p>Description: </p>
 * 
 * <p>Copyright: Copyright (c) 2015</p>
 *
 * <p>Company: Foxconn</p>
 * 
 * @date 2015-1-15 下午3:33:53
 *
 * @author kevin
 * @version 1.1
 */
public abstract class JunitTestBase {

	protected ApplicationContext context;
	BeanFactory beanFactory;

	String[] paths = {"configs/applicationContext.xml"};
	
	{
		context = new ClassPathXmlApplicationContext(paths); 
	}
	
	@Before
	public void init() {

	}
}
