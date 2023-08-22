package com.project.entities;

import org.springframework.stereotype.Component;

@Component
public class AnswerModel {

	private String msg;
	
	public AnswerModel() {
	}

	public AnswerModel(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
