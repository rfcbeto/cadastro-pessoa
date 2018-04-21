package br.com.cadastro.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.cadastro.fto.PessoaFTO;
import br.com.cadastro.model.Endereco;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.service.PessoaService;

@Controller
@RequestMapping(value="/pessoa")
public class PessoaController {
	
	private static final String FORM = "pessoa/form";
	private static final String LIST = "pessoa/list";
	
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public ModelAndView initPessoa(Model model){
		ModelAndView view = new ModelAndView(FORM);
		model.addAttribute("fto", new PessoaFTO());

		LOGGER.info("+++++CADASTRO INICIADO!+++++");
		return view;
	}
	
	/*
	@Autowired
	private EstadoRepository repository;*/
	//private static final String URL_JSON = "http://wsloterias.azurewebsites.net/api/sorteio/getresultado/1";
	
	private static final Logger LOGGER = Logger.getLogger(PessoaController.class.getName());
	
	@Autowired
	private PessoaService pessoaService;
	
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public ModelAndView listarPessoas(){
		LOGGER.info(">>>INICIO LISTAR PESSOA");
		ModelAndView mv = new ModelAndView(LIST);
		
		List<Pessoa> pessoas = pessoaService.findAll();
		mv.addObject("pessoas", pessoas);
		LOGGER.info(">>>FIM LISTAR PESSOA");
		return mv;
	}
	
	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") Long id){
		LOGGER.info(">>>INICIO LISTAR PESSOA");
		ModelAndView mv = new ModelAndView(LIST);
		
		List<Pessoa> pessoas = new ArrayList<>(); 
		pessoas.add(pessoaService.findOne(id));
		
		mv.addObject("pessoas", pessoas);
		LOGGER.info(">>>FIM LISTAR PESSOA");
		return mv;
	}
	
	@RequestMapping(value="/salvar", method = RequestMethod.POST)
	public ModelAndView cadastrarPessoa (@Valid @ModelAttribute("fto") PessoaFTO fto, BindingResult result, 
			HttpServletResponse response, RedirectAttributes redirectAttibutes){
		ModelAndView mv = new ModelAndView("index");
		
		if(result.hasErrors()){
			mv = new ModelAndView(FORM);
			String errorMessage = "";
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			List<ObjectError> errors = result.getAllErrors();
			for( ObjectError e : errors){
  				errorMessage += "ERROR: " + e.getDefaultMessage()+"\n";
  			}
			
			LOGGER.info(">>> Tipo que deu merda:\n-"+errorMessage);
			return mv;
		}
		
		pessoaService.insert(getPessoa());
		System.out.println(fto);
		LOGGER.info(">>> SALVAR PESSOA");
		return mv;
	}
	
	
	public Pessoa getPessoa() {
		Pessoa p = new Pessoa();
		p.setNome("Etelvino da silva");
		p.setCpf("12345678910");
		p.setEstadoCivil("solteiro");
		p.setRg("123456789");
		p.setSexo("Feminino");
		
		List<Endereco> lEndereco = new ArrayList<>();
		Endereco end1 = new Endereco();
		end1.setPessoa(p);
		end1.setBairro("Centro");
		end1.setCep("12345678");
		end1.setComplemento("Apt 555");
		end1.setMunicipio("Centro");
		end1.setNumero(123);
		end1.setRua("RUA teste cadastro");
		lEndereco.add(end1);
		
		p.setEndereco(lEndereco);
		return p;
	}
	
	
	
	/*
	@RequestMapping(value="/salvar", method = RequestMethod.POST)
	public ModelAndView cadastrarPessoa (PessoaFTO fto){
		ModelAndView mv = new ModelAndView("index");
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(readUrl(URL_JSON));
			JSONObject jsonObject = (JSONObject)obj;
			
			Long numeroConcurso = (Long) jsonObject.get("NumeroConcurso");
            System.out.println("Concurso: " + numeroConcurso);

            
            JSONArray sorteios = (JSONArray) jsonObject.get("Sorteios");
            @SuppressWarnings("rawtypes")
			Iterator i = sorteios.iterator();
            JSONArray jsonArrayDezenasSorteadas = null;
            
            while (i.hasNext()){
            	JSONObject dezenasSorteadas = (JSONObject) i.next();
            	 jsonArrayDezenasSorteadas  = (JSONArray)dezenasSorteadas.get("Numeros");
            }
            Set<Double> dezenasOrdenadas = new TreeSet<Double>(jsonArrayDezenasSorteadas);
            System.out.println("Numero: "+dezenasOrdenadas);
            
            mv.addObject("concurso", "TESTE");
            mv.addObject("dezenasSorteadas", dezenasOrdenadas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LOGGER.info(">>> SALVAR PESSOA");
		return mv;
	}*/
/*	
	@RequestMapping(value="/estados", method = RequestMethod.GET)
	public ModelAndView recuperarEstado(String nome){
		ModelAndView mv = new ModelAndView("index");
	
		Iterable<Estado> estados =  repository.findAll();
		for (Estado estado : estados) {
			System.out.println(estado);
		}
		
		mv.addObject("estados", "TESTE");
		return mv;
	}
*/

	
	public static String readUrl(String url_json) throws Exception{
		BufferedReader reader = null;
		
		try {
			URL url = new URL(url_json);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while((read = reader.read(chars)) != -1){
				buffer.append(chars, 0, read);
			}
			return buffer.toString();
		} finally {
			if (reader != null){
				reader.close();
			}
		}
	}
}
