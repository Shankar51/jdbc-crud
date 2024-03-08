package com.shan.exception;

public class InvalidAddressLengthException extends Exception {

	private static final long serialVersionUID = 1L;
		String mesg;
		public InvalidAddressLengthException(String mesg){
			this.mesg=mesg;
		}
		public String getMesg() {
			return this.mesg;
		}
		
		
}
