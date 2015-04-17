package com.kv.domain.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kv.domain.User;

public interface UserMapper {

	@Select("select * from t_user where username = #{username} and password = #{password}")
	@ResultMap(value = "userMap")
	public User find(@Param("username") String username, @Param("password") String password);
	
	@Select("select * from t_user")
	@Results(value = {
		@Result(id = true, property = "userId", column = "userId"),
		@Result(property = "username", column = "username"),
		@Result(property = "password", column = "password"),
		@Result(property = "nickname", column = "nickname"),
		@Result(property = "email", column = "email")
	})
	public List<User> list();
	
	@Select("select * from t_user where username = #{username}")
	@ResultMap(value = "userMap")
	public User getUserByName(String name);
	
	@Insert("insert into t_user(username, password, nickname, email) values (#{username},#{password},#{nickname},#{email})")
	@Options(useGeneratedKeys = true, keyProperty = "id")		// 字段生成主键
	public void insert(User user);
	
	@Update("update t_user set username=#{username}, password=#{password}, nickname=#{nickname}, email=#{email} where userId = #{userId}")
	public void update(User user);
	
	@Delete("delete from t_user where userId = #{userId}")
	public void delete(int userId);
	
}