package com.kv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kv.model.User;

public interface UserMapper {

	@Select("select * from t_user where username = #{username} and password = #{password}")
	public User find(@Param("username") String username, @Param("password") String password);
	
	@Select("select * from t_user")
	public List<User> listUser();
	
	public void save(User user);
	
}
