package com.bruno.helpdesk.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bruno.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.bruno.helpdesk.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException ex,
			HttpServletRequest request) {
		
		StandardError error = new StandardError.Builder()
				.setTimestamp(System.currentTimeMillis())
				.setStatus(HttpStatus.NOT_FOUND.value())
				.setError("Object Not Found")
				.setMessage(ex.getMessage())
				.setPath(request.getRequestURI())
				.build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException ex,
			HttpServletRequest request) {
		
		StandardError error = new StandardError.Builder()
				.setTimestamp(System.currentTimeMillis())
				.setStatus(HttpStatus.BAD_REQUEST.value())
				.setError("Violação de dados")
				.setMessage(ex.getMessage())
				.setPath(request.getRequestURI())
				.build();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationError(MethodArgumentNotValidException ex,
			HttpServletRequest request) {
		
		ValidationError errors = new ValidationError(new StandardError.Builder()
				.setTimestamp(System.currentTimeMillis())
				.setStatus(HttpStatus.BAD_REQUEST.value())
				.setError("Validation error")
				.setMessage("Erro na validação dos campos")
				.setPath(request.getRequestURI())
				.build());
		
		for(FieldError x : ex.getBindingResult().getFieldErrors()) {
			errors.addError(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
}
