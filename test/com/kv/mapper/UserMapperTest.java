package com.kv.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.kv.domain.Role;
import com.kv.domain.User;
import com.kv.domain.mappers.UserMapper;
import com.kv.util.MyBatisUtil;

public class UserMapperTest {

	static SqlSessionFactory sqlSessionFactory = null;
	static {
		sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
	}
	
	@Test
	public void testAdd() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			User user = new User("mnt", "123", "测试", "mnt@126.com");
			Role role = new Role(1);
			user.setRole(role);
			
			mapper.insert(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
