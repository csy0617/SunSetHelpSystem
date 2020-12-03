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
public class Old {
	private Integer OldId;
	private String OldName;
	private Date AddTime;
	private String OldSex;
	private Integer OldAge;
	private String Address;
	private String Contact;
	private Integer UserId;
	public Old(String oldName, String oldSex, Integer oldAge, String address, String contact) {
		super();
		OldName = oldName;
		OldSex = oldSex;
		OldAge = oldAge;
		Address = address;
		Contact = contact;
	}
	@Override
	public String toString() {
		return OldId + "\t"+ OldName + "\t" + OldSex + "\t" + OldAge + "\t" + Address
				+ "\t" + Contact;
	}
	
}
