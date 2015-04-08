package com.kv.model;

public class Person {
	
	private String name;
	private String sex;
	private int age;
	private int id;
	
	public Person() {
		
	}

	public Person(String name, String sex, int age, int id) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", age=" + age
				+ ", id=" + id + "]";
	}
	
}
