package br.com.cadastro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.cadastro.exceptions.CustomNotFoundException;
import br.com.cadastro.model.Customer;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.service.CustomerService;

@RestController
public class UserController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/teste", method=RequestMethod.GET)
	public ModelAndView getTeste(){
		List<String> list = getList();
		ModelAndView model = new ModelAndView("index");
		model.addObject("lists", list);
		
		return model;
	}
	
	private List<String> getList(){
		List<String> list = new ArrayList<>();
		list.add("L A");
		list.add("L B");
		list.add("L C");
		list.add("L D");
		
		return list;
	}
	
	@RequestMapping(value = "/clientes")
	public List<Pessoa> findCustomers(){
		
		List<Pessoa> pessoas = customerService.findAllCustomers();
		
		if(null==pessoas){
			throw new CustomNotFoundException("Nenhum cliente cadastrado!");
		}
		return pessoas;
	}
	
	@RequestMapping(value = "/cliente/{name}")
	public Customer findCustomerByName(@PathVariable("name")String name){
		
		Customer cust = customerService.findCustomerByName(name);
		
		if(null==cust){
			throw new CustomNotFoundException("Nenhum cliente com o nome: "+name);
		}
		return cust;
	}
}
