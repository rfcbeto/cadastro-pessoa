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
@EnableWebMvc
@ComponentScan("br.com.cadastro")
@EntityScan("br.com.cadastro")
@EnableJpaRepositories("br.com.cadastro")
@EnableAutoConfiguration
public class CadastroClienteApplication {
	
	public static void main(String[] args) throws InterruptedException {
<<<<<<< Updated upstream:cadastro-pessoa-web/src/main/java/br/com/cadastro/config/CadastroClienteApplication.java
=======
	
>>>>>>> Stashed changes:src/main/java/br/com/cadastro/config/CadastroClienteApplication.java
		SpringApplication.run(CadastroClienteApplication.class, args);
		
	}
	
	/*
	@Bean
	public CommandLineRunner run(ViaCEPClient client){
		return args -> {
			if(args.length > 0){
				String cep = "30644220";
				Endereco endereco = client.buscaEnderecoPorCep(cep);
				System.out.println(">>>>>>>"+endereco);
			}
		};
	}*/
	
	@Controller
	public class HomeController {
		@RequestMapping("/home")
		public ModelAndView home(Model model) {
			ModelAndView mv = new ModelAndView("index");
			return mv;
		}
		
		@RequestMapping("/map")
		public ModelAndView maps() {
			ModelAndView mv = new ModelAndView("map");
			return mv;
		}
	}	
}
