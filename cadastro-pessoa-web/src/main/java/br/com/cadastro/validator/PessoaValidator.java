package br.com.cadastro.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.cadastro.fto.PessoaFTO;

public class PessoaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PessoaFTO.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "nome", "Nome não pode ser vázio");
		PessoaFTO fto = (PessoaFTO)obj;
		if (fto.getCpf().isEmpty()) {
			e.rejectValue("cpf", "Campo vazio.");
		}
		
	}

}
