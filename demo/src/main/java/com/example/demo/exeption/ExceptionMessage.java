package com.example.demo.exeption;

public class ExceptionMessage extends Exception{
	
	private static final long serialVersionUID = -5928434483633910456L;

	public ExceptionMessage(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionMessage(String message) {
		super(message);
	}

}
