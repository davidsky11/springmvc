package com.kv.domain;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Alias("User")
public class User implements Serializable {

	private static final long serialVersionUID = -674520540207871580L;
	
	private Integer id;
	private String username;
	private String nickname;
	private String password;
	private String email;
	
	public User() {
		
	}
	
	public User(String username, String password, String nickname, String email) {
		super();
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
	}
	
	public User(Integer id, String username, String nickname, String password,
			String email) {
		super();
		this.id = id;
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotEmpty(message = "用户名不能为空")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Size(min = 1, max = 10, message="密码的长度应该在1和10 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Email(message = "邮箱的格式不正确")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", nickname="
				+ nickname + ", password=" + password + ", email=" + email
				+ "]";
	}
	
}
