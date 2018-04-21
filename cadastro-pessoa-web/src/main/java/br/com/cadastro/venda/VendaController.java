package br.com.cadastro.venda;

import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cadastro.model.Pessoa;
import br.com.cadastro.service.PessoaService;

@Controller
@RequestMapping("/venda")
public class VendaController {
	private static final Logger LOGGER = Logger.getLogger(VendaController.class.getName());
	private static final String FORM = "sucesso";
	
	@Autowired
	private VendaService service;
	
	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
    public String cadastrarVenda(Model model){
		LOGGER.info("Iniciando o cadastramento da venda");
    	service.init(model);
    	return "venda/form";
    }
	

	@RequestMapping(value="/salvar", method = RequestMethod.GET)
	public ModelAndView cadastrarPessoa (@Valid @ModelAttribute("fto") VendaFTO fto, BindingResult result, 
			HttpServletResponse response, RedirectAttributes redirectAttibutes){
		ModelAndView mv = new ModelAndView(FORM);
		
		Venda venda = service.insert(getVenda());
		System.out.println(fto);
		LOGGER.info("Venda: " + venda + " Cadastrada com sucesso!");
		return mv;
	}


	private Venda getVenda() {
		Venda venda = new Venda();
		venda.setPessoa(pessoaService.findOne(2L));
		Locale local = new Locale("pt", "BR");
		venda.setDataVenda(Calendar.getInstance(local));
		venda.setQuantidade(3);
		venda.setStatus("Pendente");
		venda.setTotalVenda(250.00);
		venda.setFormaPagamento("Cheque");
		
		return venda;
	}
}

