package com.github.kairos.middleware.exceptionhandler.exceptions;

public class CardNotFoundException extends RuntimeException {
	public CardNotFoundException(Long id) {
		new StringBuilder();
		super(String.format("Card with id:%s not found", id));
	}
}
