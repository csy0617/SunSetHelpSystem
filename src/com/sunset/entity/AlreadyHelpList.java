package com.sunset.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlreadyHelpList {
	private String oldName;
	private String helpDescription;
	private Date addtime;
	@Override
	public String toString() {
		return oldName + "\t" + helpDescription + "\t" + addtime;
	}
	
}
