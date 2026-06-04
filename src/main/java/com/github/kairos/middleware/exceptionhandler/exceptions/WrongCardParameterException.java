package com.github.kairos.middleware.exceptionhandler.exceptions;

public class WrongCardParameterException extends RuntimeException {
	public WrongCardParameterException(String parameter) {
		super("Wrong parameter type used: " + parameter);
	}
}
