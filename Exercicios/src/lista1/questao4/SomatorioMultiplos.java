package lista1.questao4;

import java.util.ArrayList;

public class SomatorioMultiplos {

	public static void main(String[] args) {
		
		int multiplo=1,somador=0;
		
		ArrayList<Integer> multiplos = new ArrayList<>();
		
		while(multiplo<1000) {
			
			if(multiplo%3==0 || multiplo%5==0) {
				
				somador+=multiplo;	
				
				multiplos.add(multiplo);
			}			
			multiplo++;
		}
		
		
		for(int numero: multiplos) {
			
			System.out.println(numero);
			
		}
		
		System.out.println(somador);
	}

}
