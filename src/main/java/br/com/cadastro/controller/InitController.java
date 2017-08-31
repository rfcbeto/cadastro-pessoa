package br.com.cadastro.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cadastro.fto.PessoaFTO;

@Controller
public class InitController {
	private static final Logger LOGGER = Logger.getLogger(InitController.class.getName());

	@RequestMapping(value="/cad", method = RequestMethod.GET)
	public ModelAndView home(Model model){
		ModelAndView view = new ModelAndView("cadastro");
		model.addAttribute("fto", new PessoaFTO());
		view.addObject(model);

		LOGGER.info("+++++CADASTRO INICIADO!+++++");
		return view;
	}
	
	
}
