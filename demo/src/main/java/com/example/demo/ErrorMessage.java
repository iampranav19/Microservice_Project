package com.example.demo;

import org.springframework.http.HttpStatus;

public class ErrorMessage {

	private HttpStatus status;
	private String msg;
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorMessage(HttpStatus status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}
	
	
}
