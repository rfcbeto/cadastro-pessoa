package br.com.cadastro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cadastro.model.Endereco;
import br.com.cadastro.repository.EnderecoRepository;

@Component
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> findAll(){
		List<Endereco> enderecos = new ArrayList();
		enderecos = repository.findAll();
		for (Endereco endereco : enderecos) {
			System.out.println(endereco);
		}
		
		return enderecos;
	}
	
	public Endereco findOne(Long id) {
        return repository.findOne(id);
    }
	
	public void insert(Endereco endereco){
		repository.save(endereco);
	}
}
