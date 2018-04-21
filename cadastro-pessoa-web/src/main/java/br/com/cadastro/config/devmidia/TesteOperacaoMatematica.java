package br.com.cadastro.config.devmidia;

import org.springframework.stereotype.Controller;

@Controller
public class TesteOperacaoMatematica {

	public static void calculaOperacao(OperacaoMatematica o, double x, double y ){
		System.out.println("| "+o.calcular(x, y)+" |");
	}
	/*
	public static void main(String[] args) {
		calculaOperacao(new Soma(), 25, 20);
		calculaOperacao(new Multiplicacao(), 3, 25);
		calculaOperacao(new Subtracao(), 250, 200);
		calculaOperacao(new Divisao(), 2500, 200);
		
		//System.out.println("| "+(new Multiplicacao().multiplicar(3, 5))+" |");
		System.out.println("-------------------");
		fibonacciIterativo(10);
	}
	*/
	
	public static int fibonacciIterativo(int termo) {
	    int termo1 = 1, fibo = 0, temp = 0;
	    for (int cont = 1;cont <= termo-1; cont++) {
	        temp = fibo; 	//faz o giro, a variável temp serve somente para que não sejam perdidos valores
	        fibo += termo1; //observe, são necessárias 3 variáveis
	        termo1 = temp;
	        System.out.print(termo1+" ");
	    }
	    return fibo;
	}
}
