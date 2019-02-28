package com.example.spring02.model.message.dto;

import java.util.Date;

public class MessageDTO {
	private int mid;
	private String 	targetid;
	private String 	sender;
	private String	message;
	private Date 	opendate;
	private Date	senddate;
	protected int getMid() {
		return mid;
	}
	protected void setMid(int mid) {
		this.mid = mid;
	}
	protected String getTargetid() {
		return targetid;
	}
	protected void setTargetid(String targetid) {
		this.targetid = targetid;
	}
	protected String getSender() {
		return sender;
	}
	protected void setSender(String sender) {
		this.sender = sender;
	}
	protected String getMessage() {
		return message;
	}
	protected void setMessage(String message) {
		this.message = message;
	}
	protected Date getOpendate() {
		return opendate;
	}
	protected void setOpendate(Date opendate) {
		this.opendate = opendate;
	}
	protected Date getSenddate() {
		return senddate;
	}
	protected void setSenddate(Date senddate) {
		this.senddate = senddate;
	}
	@Override
	public String toString() {
		return "MessageDTO [mid=" + mid + ", targetid=" + targetid + ", sender=" + sender + ", message=" + message
				+ ", opendate=" + opendate + ", senddate=" + senddate + "]";
	}
	
	
}
