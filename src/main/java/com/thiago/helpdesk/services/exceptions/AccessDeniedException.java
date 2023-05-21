package com.thiago.helpdesk.services.exceptions;

public class AccessDeniedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccessDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccessDeniedException(String message) {
		super(message);
	}

	
}
