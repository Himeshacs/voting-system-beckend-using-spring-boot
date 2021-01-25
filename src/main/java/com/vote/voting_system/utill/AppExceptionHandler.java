package com.vote.voting_system.utill;



import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
/*
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
		String requestPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE, 0);
		ErrorMessage errorMessage = new ErrorMessage(new Date(), 500, ex.toString(), requestPath);
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	*/
	
/*	
	@ExceptionHandler(value = { CustomUserException.class })
	public ResponseEntity<Object> customUserException(CustomUserException ex, WebRequest request) {
		String requestPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE, 0);
		ErrorMessage errorMessage = new ErrorMessage(new Date(), 500, ex.toString(), requestPath);
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { JSONException.class })
	public ResponseEntity<Object> ffdf(JSONException ex, WebRequest request) {
		String requestPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE, 0);
		ErrorMessage errorMessage = new ErrorMessage(new Date(), 500, ex.toString(), requestPath);
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	*/
}
