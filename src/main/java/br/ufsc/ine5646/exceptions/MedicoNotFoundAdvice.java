package br.ufsc.ine5646.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MedicoNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(MedicoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String playerNotFoundHandler(MedicoNotFoundException ex) {
		return ex.getMessage();
	}
	
}