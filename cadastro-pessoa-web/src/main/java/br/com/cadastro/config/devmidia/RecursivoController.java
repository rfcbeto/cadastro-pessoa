package br.com.cadastro.config.devmidia;

public class RecursivoController {

	private static int[] vetAux = new int[5];
	private static int k;
	
	private static long fibo(int ent) {
			k = 1;
		return recu(ent);
	}

	private static long recu(int i) {
		if(i < 0){
			return vetAux[0];
		} else {
			if (k < 3) {
				vetAux[i] = k - 1;
				k++;
			} else {
				vetAux[i] = vetAux[i + 1] + vetAux[i + 2];
			}
			return recu(i - 1);
		}
	}
	/*
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.print(fibo(i)+ "\t");
		}
	}*/
	
}
