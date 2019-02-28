package com.example.spring02.model.message.dto;

public class UserDTO {
	private String userid;
	private String upw;
	private String name;
	private int upoint;
	
	protected String getUserid() {
		return userid;
	}
	protected String getUpw() {
		return upw;
	}
	protected String getName() {
		return name;
	}
	protected int getUpoint() {
		return upoint;
	}
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", upw=" + upw + ", name=" + name + ", upoint=" + upoint + "]";
	}
	
	
	
}
