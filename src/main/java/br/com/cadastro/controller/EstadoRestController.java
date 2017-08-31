package br.com.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cadastro.model.Estado;
import br.com.cadastro.model.EstadoDAO;
import br.com.cadastro.service.EstadoService;

@Controller
@RequestMapping("/estado")
public class EstadoRestController {

	@Autowired
	private EstadoDAO dao;
	
	@Autowired
	private EstadoService service;
	
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
		ModelAndView mv = new ModelAndView("/cadastro");
		mv.addObject("estado", service.findAll());
		
		return mv;
	}
}
