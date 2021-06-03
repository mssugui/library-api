package com.muhamadsugui.libraryapi.exception;

public class FunctionalException extends RuntimeException {

	public static final String ITEM_NOT_FOUND = "Sorry, the element you are trying to update cannot be found.";
	public static final String INTERNAL_ERROR = "Internal Error. Sorry, it was not possible to complete your request.";

	public FunctionalException(String message) {
		super(message);
	}

}
