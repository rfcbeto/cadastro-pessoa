package br.com.cadastro.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DataUtil {

	public static Date stringToDate(String data) throws ParseException{
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.parse(data);
	}
}
