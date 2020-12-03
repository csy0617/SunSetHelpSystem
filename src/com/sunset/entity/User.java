package com.sunset.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	private Integer Id;
	private String Name;
	private String userName;
	private String Password;
	private String Sex;
	private Integer Age;
	private Integer Phone;
	public User(String name, String userName, String password, String sex, Integer age, Integer phone) {
		super();
		Name = name;
		this.userName = userName;
		Password = password;
		Sex = sex;
		Age = age;
		Phone = phone;
	}
}
