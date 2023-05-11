package br.com.rsds.sigame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.rsds.sigame.exception.RecordNotFoundException;

@RestControllerAdvice
public class AplicationControllerAdvace {

	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String HandlerNotFoundException(RecordNotFoundException ex) {
		return ex.getMessage();
	}
}
