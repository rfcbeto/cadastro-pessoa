package br.com.cadastro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.fto.PessoaFTO;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> findAll(){
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas = repository.findAll();
		PessoaFTO fto = new PessoaFTO();
		
		for (Pessoa p : pessoas) {
			System.out.println("Entidade: " + p.getNome());
			System.out.println("--------------------------------------");
			BeanUtils.copyProperties(p, fto); 
			System.out.println("Objeto: "+fto);
		}
		
		return pessoas;
	}
	
	public Pessoa findOne(Long id) {
        return repository.findOne(id);
    }
	
	public void insert(Pessoa pessoa){
		repository.save(pessoa);
	} 
}
