package br.com.cadastro.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cadastro.model.Endereco;
import br.com.cadastro.service.EnderecoService;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {

	private static final Logger LOGGER = Logger.getLogger(EnderecoController.class.getName());
	
	@Autowired
	private EnderecoService enderecoService;
	
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public ModelAndView listarEndereco(){
		LOGGER.info(">>>INICIO LISTAR ENDERECO");
		
		ModelAndView mv = new ModelAndView("listaendereco");
		
		List<Endereco> enderecos = enderecoService.findAll();
		mv.addObject("enderecos", enderecos);
		LOGGER.info(">>>FIM LISTAR ENDERECOS");
		return mv;
	}
	
	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	public ModelAndView getByPessoaId(@PathVariable("id") Long id){
		LOGGER.info(">>>INICIO LISTAR ENDERECOS");
		ModelAndView mv = new ModelAndView("listaendereco");
		
		List<Endereco> enderecos = new ArrayList<>(); 
		enderecos.add(enderecoService.findOne(id));
		mv.addObject("enderecos", enderecos);
		LOGGER.info(">>>FIM LISTAR ENDERECOS");
		
		return mv;
	}
}
