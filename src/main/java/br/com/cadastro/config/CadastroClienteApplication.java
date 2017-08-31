package br.com.cadastro.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc //<mvc:annotation-driven />
@ComponentScan("br.com.cadastro")
@EntityScan("br.com.cadastro.model")
@EnableJpaRepositories("br.com.cadastro.repository")
@EnableAutoConfiguration
public class CadastroClienteApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CadastroClienteApplication.class, args);
	}
	
	@Controller
	public class HomeController {
		@RequestMapping("/home")
		public ModelAndView home(Model model) {
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("TESTE", "Valor Teste");
			return mv;
		}
	}	
}
