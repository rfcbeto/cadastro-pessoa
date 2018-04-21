package br.com.cadastro.componete;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cadastro.model.Endereco;

@Component
public class ViaCEPClient {

	public Endereco buscaEnderecoPorCep(String cep){
		RestTemplate template = new RestTemplate();
		
		return template.getForObject("https://viacep.com.br/ws/{cep}/json", Endereco.class, cep);
	}
}
