package com.sunset.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OldUserHelp {
	private Integer oldID;
	private String oldName;
	@Override
	public String toString() {
		return oldID + "\t" + oldName;
	}
	
}
