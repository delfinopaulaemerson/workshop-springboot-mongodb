package com.workshopmongo.curso.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.workshopmongo.curso.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	public ResponseEntity<StandardError>objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Não Encontrado", e.getMessage(), request.getRequestURI());
		
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
	}
}
