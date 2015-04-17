package com.kv.domain.mappers;

import org.apache.ibatis.annotations.Select;

import com.kv.domain.Role;

public interface RoleMapper {

	@Select("select * from t_role where roleId = #{roleId}")
	public Role getById(int roleId);
}
