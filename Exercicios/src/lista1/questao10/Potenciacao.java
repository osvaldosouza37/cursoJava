package lista1.questao10;

public class Potenciacao {

	public static void main(String[] args) {
	
		int base = (int) Math.round(Math.random()*5)+1;
		
		int expoente = (int) Math.round(Math.random()*5);
		
		if(expoente==0) {
			System.out.println(base+" elevado a 0 = 1");
		}else {
			
			int multiplicador=1,resultado=1;
			
			while(multiplicador<=expoente) {
				resultado*=base;
				
				multiplicador++;
			}
			
			System.out.println(base+" elevado a "+expoente+" = "+resultado);
		}

	}

}
