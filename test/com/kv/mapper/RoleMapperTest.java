package com.kv.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.kv.domain.Role;
import com.kv.domain.mappers.RoleMapper;
import com.kv.util.MyBatisUtil;

public class RoleMapperTest {

	static SqlSessionFactory sqlSessionFactory = null;
	static {
		sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
	}
	
	@Test
	public void testAdd() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
			Role role = new Role();
			role.setRoleName("测试用户");
			
			sqlSession.commit();		
		} finally {
			sqlSession.close();
		}
	}
}
