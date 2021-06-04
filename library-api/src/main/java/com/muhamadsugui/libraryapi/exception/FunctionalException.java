package com.muhamadsugui.libraryapi.exception;

public class FunctionalException extends RuntimeException {

	public static final String ITEM_NOT_FOUND = "Sorry, the element you are trying to update cannot be found.";
	public static final String INTERNAL_ERROR = "Internal Error. Sorry, it was not possible to complete your request.";
	public static final String VIOLATION_EXCEPTION = "We got a validation error. Check if the data you are trying to insert is consistent.";

	public FunctionalException(String message) {
		super(message);
	}

}
