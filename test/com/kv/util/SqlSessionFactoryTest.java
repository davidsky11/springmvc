package com.kv.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.DataSourceFactory;
import org.junit.Before;
import org.junit.Test;

public class SqlSessionFactoryTest {
	
	SqlSessionFactory sqlMapper = null;
	
	@Before
	public void init() {
		
	}

	@Test
	public void buildFromXML() {
		String resource = "configs/mybatis-config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);		// 从XML中构建SqlSessionFactory
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void buildFromCode() {
//		DataSource dataSource = DataSourceFactory.
	}
	
}
