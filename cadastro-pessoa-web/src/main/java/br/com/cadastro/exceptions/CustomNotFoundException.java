package br.com.cadastro.exceptions;

public class CustomNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = -5173446336516416951L;

	public CustomNotFoundException(String msg){
		super(msg);
	}

}
