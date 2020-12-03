package com.sunset.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Help {
	private Integer HelpId;
	private Integer OldId;
	private Integer UserId;
	private Date AddTime;
	private String HelpDescription;
	public Help(Integer oldId, Integer userId, String helpDescription) {
		super();
		OldId = oldId;
		UserId = userId;
		HelpDescription = helpDescription;
	}
	
}
