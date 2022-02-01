package com.assignment.daofab.core.exceptions;

/**
 * For HTTP 404 errros
 */
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
