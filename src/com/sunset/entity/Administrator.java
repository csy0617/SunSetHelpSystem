package com.sunset.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Administrator {
	private Integer Id;
	private String AdminName;
	private String Password;
	private Date AddTime;
	public Administrator(String adminName, String password) {
		super();
		AdminName = adminName;
		Password = password;
	}
}
