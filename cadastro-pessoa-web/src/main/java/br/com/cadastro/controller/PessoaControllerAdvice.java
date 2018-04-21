package br.com.cadastro.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.cadastro.exceptions.CustomNotFoundException;
import br.com.cadastro.mensagens.ResponseMsg;

@RestControllerAdvice
public class PessoaControllerAdvice {
	
	@ExceptionHandler(CustomNotFoundException.class)
	public ResponseMsg hundleNotFoundException(CustomNotFoundException ex){
		ResponseMsg responseMsg = new ResponseMsg(ex.getMessage());
		return responseMsg;
	}
}
