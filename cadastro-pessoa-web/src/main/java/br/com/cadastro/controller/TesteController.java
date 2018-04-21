package br.com.cadastro.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cadastro.model.PersonForm;

@Controller
@RequestMapping(value="/cadTeste")
public class TesteController extends WebMvcConfigurerAdapter{


	@Override
    public  void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }
	
    @GetMapping("/showForm")
    public String showForm(Model model) {
    	
		model.addAttribute("person", new PersonForm());
		
        return "form";
    }


    
    @PostMapping("/checkPerson")
    public String checkPersonInfo(@Valid @ModelAttribute("personForm") PersonForm personForm, BindingResult result, 
			HttpServletResponse response, RedirectAttributes redirectAttibutes) {

        if (result.hasErrors()) {
            return "form";
        }

        return "result";
    }


}
