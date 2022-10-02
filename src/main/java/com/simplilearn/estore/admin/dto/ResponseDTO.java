package com.simplilearn.estore.admin.dto;

import java.util.Date;

public class ResponseDTO {
	
	private String message;
	private String status;
	private String error;
	private Date timestamp = new Date();
	private Object data;
	
	public ResponseDTO() {}
	public ResponseDTO(String message, String status, String error, Date timestamp, Object data) {
		super();
		this.message = message;
		this.status = status;
		this.error = error;
		this.timestamp = timestamp;
		this.data = data;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseDTO [message=" + message + ", status=" + status + ", error=" + error + ", timestamp="
				+ timestamp + "]";
	}
	
}