package br.com.cadastro.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.cadastro.repository.DataUtil;

@Component
public class PessoaDAO {

	private static List<Pessoa> lPessoa;	
	{
		lPessoa = new ArrayList<>();
		Pessoa p = new Pessoa();
		p.setNome("Roberto França Coelho");
		p.setCpf("04786771627");
		try {
			p.setDataNascimento(DataUtil.stringToDate("08/08/1982"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		p.setNacionalidade("BRASILEIRO");
		p.setNaturalidde("Belo Horizonte");
		
		Endereco endereco = new Endereco();
		endereco.setCep("30644220");
		endereco.setCidade("Belo Horizonte");
		endereco.setComplemento("Apto 203");
		endereco.setEstado("MG");
		endereco.setNumero("575");
		endereco.setPessoa(p);
		endereco.setRua("Jose dos Santos Lage");
		List<Endereco> lEnd = new ArrayList<>();
		lEnd.add(endereco);
		
		lPessoa.add(p);
		
	}
	
	public List<Pessoa> listaPessoa(){
		return lPessoa;
	}
	
	
	public Pessoa get(Long id){
		for(Pessoa p : lPessoa){
			if(p.getId() == id){
				return p;
			}
		}
		return null;
	}
}
