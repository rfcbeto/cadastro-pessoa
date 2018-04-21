package br.com.cadastro.venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import br.com.cadastro.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repository;
	
	public Venda insert(Venda venda){
		return repository.save(venda);
	} 
	
	public void init(Model model) {
		
	}
}
