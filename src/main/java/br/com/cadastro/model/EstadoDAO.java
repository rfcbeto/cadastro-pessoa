package br.com.cadastro.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EstadoDAO {

	private static List<Estado> estados;	
	{
		estados = new ArrayList<>();
		Estado estado = new Estado();
		estado.setId(01);
		estado.setNomeEstado("Acre");
		estado.setSiglaEstado("AC");
		estado.setCapital("Rio Branco");
		estado.setRegiao("Norte");
		estados.add(new Estado(estado));
		
		estado = new Estado();
		estado.setId(02);
		estado.setNomeEstado("Minas Gerais");
		estado.setSiglaEstado("MG");
		estado.setCapital("Belo Horizonte");
		estado.setRegiao("Sudeste");
		estados.add(new Estado(estado));
		
		estado = new Estado();
		estado.setId(03);
		estado.setNomeEstado("Santa Catarina");
		estado.setSiglaEstado("SC");
		estado.setCapital("Florianópolis");
		estado.setRegiao("Sul");
		estados.add(new Estado(estado));
		
		estado = new Estado();
		estado.setId(04);
		estado.setNomeEstado("Distrito Federal");
		estado.setSiglaEstado("DF");
		estado.setCapital("Brasília");
		estado.setRegiao("Centro-Oeste");
		estados.add(new Estado(estado));
		
		estado = new Estado();
		estado.setId(05);
		estado.setNomeEstado("Paraná");
		estado.setSiglaEstado("PR");
		estado.setCapital("Curitiba");
		estado.setRegiao("Sul");
		estados.add(new Estado(estado));
		
		estado = new Estado();
		estado.setId(06);
		estado.setNomeEstado("Pernambuco");
		estado.setSiglaEstado("PE");
		estado.setCapital("Recife");
		estado.setRegiao("Nordeste");
		estados.add(new Estado(estado));
		
		estado = new Estado();
		estado.setId(07);
		estado.setNomeEstado("Amazonas");
		estado.setSiglaEstado("AM");
		estado.setCapital("Manaus");
		estado.setRegiao("Norte");
		estados.add(new Estado(estado));
		
	}
	
	public List<Estado> listaEstados(){
		return estados;
	}
	
	public Estado get(Integer id){
		for(Estado e : estados){
			if(e.getId().equals(id)){
				return e;
			}
		}
		return null;
	}
}
