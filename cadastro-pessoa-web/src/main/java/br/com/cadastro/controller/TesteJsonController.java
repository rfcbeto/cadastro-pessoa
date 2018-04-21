package br.com.cadastro.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/testeJson")
public class TesteJsonController {

	final static String URL_JSON = "http://wsloterias.azurewebsites.net/api/sorteio/getresultado/1";
	
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
	/*
	public static void main(String[] args) throws Exception {
		
	    // Connect to the URL using java's native library
	    URL url = new URL(URL_JSON);
	    HttpURLConnection request = (HttpURLConnection) url.openConnection();
	    request.connect();

	    // Convert to a JSON object to print data
	    JsonParser jp = new JsonParser(); 
	    
	    //from gson
	    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); 
	    
	    //Convert the input stream to a json element
	    JsonObject rootobj = root.getAsJsonObject(); 
	    
	    //May be an array, may be an object. 
	    JsonArray arraySorteios = rootobj.get("Sorteios").getAsJsonArray(); //just grab the zipcode
		Iterator i = arraySorteios.iterator();
		
		System.out.println(arraySorteios);
		/*
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(readUrl(URL_JSON));
			JSONObject jsonObject = (JSONObject)obj;
			System.out.println(jsonObject);
			
			Long numeroConcurso = (Long) jsonObject.get("NumeroConcurso");
            System.out.println(numeroConcurso);

            
            JSONArray sorteios = (JSONArray) jsonObject.get("Sorteios");
            System.out.println(sorteios);
            Iterator i = sorteios.iterator();
            JSONArray jsonArrayNum = null;
            
            while (i.hasNext()){
            	 
            	JSONObject numeros = (JSONObject) i.next();
            	 jsonArrayNum  = (JSONArray)numeros.get("Numeros");
            	
            }
            System.out.println(jsonArrayNum);
		} catch (Exception e) {
			
		}
		
	}*/
}
