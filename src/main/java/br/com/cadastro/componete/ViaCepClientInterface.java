package br.com.cadastro.componete;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.cadastro.model.Endereco;

@FeignClient(url="https://viacep.com.br/ws/", name = "vaicep")
public interface ViaCepClientInterface {
	@GetMapping("{cep}/json")
	Endereco buscaEnderecoPorCep(@PathVariable("cep") String cep);

}
