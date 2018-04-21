package br.com.cadastro.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cadastro.fto.PessoaFTO;
import br.com.cadastro.model.Estado;
import br.com.cadastro.model.EstadoDAO;
import br.com.cadastro.repository.EstadoRepository;
import br.com.cadastro.service.EstadoService;

@Controller
@RequestMapping("/estado")
public class EstadoRestController {

	@Autowired
	private EstadoDAO dao;
	
	@Autowired
	private EstadoRepository repository;
	
	@Autowired
	private EstadoService service;
	
	/*****************************************************/
	
		@GetMapping(path="/add") // Map ONLY GET Requests
		public @ResponseBody String addNewUser () {
			
			List<Estado> lEstado = new ArrayList<>();
			Estado estado = new Estado();
			estado.setCapital("Belo Horizonte");
			//estado.setId(1);
			estado.setNomeEstado("Minas Gerais");
			estado.setRegiao("Sudeste");
			estado.setSiglaEstado("MG");
			lEstado.add(estado);
			
			estado = new Estado();
			estado.setCapital("Florianopolis");
			//estado.setId(2);
			estado.setNomeEstado("Santa Catarina");
			estado.setRegiao("Sul");
			estado.setSiglaEstado("SC");
			lEstado.add(estado);
			
			
			estado = new Estado();
			estado.setCapital("São Paulo");
			//estado.setId(2);
			estado.setNomeEstado("São Paulo");
			estado.setRegiao("Sudeste");
			estado.setSiglaEstado("SP");
			lEstado.add(estado);
			
			for (Estado e : lEstado) {
				service.insert(e);
			}
			return "Saved";
		}

	
	/*****************************************************/
	
	@GetMapping("/todos")
	public ResponseEntity<Estado> getEstados(){
		return new ResponseEntity(dao.listaEstados(),HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Estado> getEstado(@PathVariable("id") Integer id){
		Estado estado = dao.get(id);
		if(estado == null){
			return new ResponseEntity("Não foi encontrado nenhum estado! "+ id, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Estado>(estado, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ModelAndView findAll(){
		ModelAndView mv = new ModelAndView("cadastro");
		mv.addObject("estado", service.findAll());
		mv.addObject("fto", new PessoaFTO());
		return mv;
	}
	
	@RequestMapping(value="date", method=RequestMethod.GET)
    public void processDate(@RequestParam("date") LocalDate date) {
        
		System.out.println(date);
		
    }
  
	@RequestMapping(value="datetime", method=RequestMethod.POST)
    public void processDateTime(@RequestParam("datetime") LocalDateTime dateAndTime) {
        //Do stuff
    	System.out.println(dateAndTime);
    }
}
