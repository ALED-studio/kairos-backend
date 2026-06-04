package com.github.kairos.middleware.exceptionhandler;

import com.github.kairos.middleware.exceptionhandler.exceptions.CardNotFoundException;
import com.github.kairos.middleware.exceptionhandler.exceptions.WrongCardParameterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CardNotFoundException.class)
	public ResponseEntity<Object> cardNotFoundHandler(
		CardNotFoundException exception,
		WebRequest request
	) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
			HttpStatus.NOT_FOUND,
			exception.getMessage()
		);
		problemDetail.setTitle("Card not found");
		problemDetail.setInstance(URI.create(request.getContextPath()));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
	}

	@ExceptionHandler(WrongCardParameterException.class)
	public ResponseEntity<Object> wrongCardParameterHandler(
		WrongCardParameterException exception,
		WebRequest request
	) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
			HttpStatus.BAD_REQUEST,
			exception.getMessage()
		);
		problemDetail.setTitle("Wrong card parameter");
		problemDetail.setInstance(URI.create(request.getContextPath()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problemDetail);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> nullPointerExceptionHandler(
		NullPointerException exception,
		WebRequest request
	) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
			HttpStatus.INTERNAL_SERVER_ERROR,
			exception.getMessage()
		);
		problemDetail.setTitle("Null pointer exception");
		problemDetail.setInstance(URI.create(request.getContextPath()));
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetail);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> noSuchElementExceptionHandler(
		NoSuchElementException exception,
		WebRequest request
	) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
			HttpStatus.INTERNAL_SERVER_ERROR,
			exception.getMessage()
		);
		problemDetail.setTitle("No such element exception");
		problemDetail.setInstance(URI.create(request.getContextPath()));
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetail);
	}
}
