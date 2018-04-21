package br.com.cadastro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.model.Estado;
import br.com.cadastro.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repository;
	
	public List<Estado> findAll(){
		List<Estado> estados = new ArrayList<>();
		estados = repository.findAll();
		for (Estado estado : estados) {
			System.out.println(estado);
		}
		
		return estados;
	}
	
	public Estado findOne(Long id) {
        return repository.findOne(id);
    }
	
	public void insert(Estado estado){
		repository.save(estado);
	}
}
