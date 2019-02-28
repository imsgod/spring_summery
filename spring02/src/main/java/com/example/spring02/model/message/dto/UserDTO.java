package com.example.spring02.model.message.dto;

public class UserDTO {
	private String userid;
	private String upw;
	private String name;
	private int upoint;
	
	public String getUserid() {
		return userid;
	}
	public String getUpw() {
		return upw;
	}
	public String getName() {
		return name;
	}
	public int getUpoint() {
		return upoint;
	}
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", upw=" + upw + ", name=" + name + ", upoint=" + upoint + "]";
	}
	
	
	
}
