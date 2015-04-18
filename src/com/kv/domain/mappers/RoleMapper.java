package com.kv.domain.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kv.domain.Role;

public interface RoleMapper {

	@Select("select * from t_role where roleId = #{roleId}")
	public Role getById(int roleId);
	
	@Select("select * from t_role")
	public List<Role> list();
	
}
