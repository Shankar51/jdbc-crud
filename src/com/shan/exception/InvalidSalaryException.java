package com.shan.exception;

public class InvalidSalaryException extends Exception {
	String mesg;

	public InvalidSalaryException(String mesg) {
		this.mesg = mesg;
	}

	public String getMesg() {
		return this.mesg;
	}
	

}
