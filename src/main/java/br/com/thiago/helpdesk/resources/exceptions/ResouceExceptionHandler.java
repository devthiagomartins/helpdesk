package br.com.thiago.helpdesk.resources.exceptions;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.thiago.helpdesk.services.exceptions.DataIntegrityViolationException;
import br.com.thiago.helpdesk.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResouceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException ex, HttpServletRequest request){
		
		
		StandardError error = new StandardError(System.currentTimeMillis(),HttpStatus.NOT_FOUND.value(), "Object Not Found", ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> ataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request){
		
		
		StandardError error = new StandardError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(), "Violação de dados", ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
	
}
