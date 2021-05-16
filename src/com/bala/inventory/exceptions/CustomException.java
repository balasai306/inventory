package com.bala.inventory.exceptions;

public class CustomException extends Exception {
	String message;
	public CustomException(String message) {
	System.out.println(message);
	}

}
