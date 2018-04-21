package br.com.cadastro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.model.Endereco;
import br.com.cadastro.repository.EnderecoRepository;

@Service
public class EnderecoService {

	
	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> findAll(){
		List<Endereco> enderecos = new ArrayList<>();
		enderecos = repository.findAll();
		/*
		//EnderecoFTO fto = new EnderecoFTO();
		for (Endereco e : enderecos) {
			System.out.println("Ba: " + e.getBairro());
			System.out.println("--------------------------------------");
			//BeanUtils.copyProperties(e, fto); 
			System.out.println("Objeto: "+e.getBairro());
		}*/
		
		return enderecos;
	}
	
	public List<Endereco> getEnderecoByNomePessoa(String nome){
		return repository.getEnderecoByNomePessoa(nome);
	}

	public Endereco findOne(Long id) {
        return repository.findOne(id);
    }
}
