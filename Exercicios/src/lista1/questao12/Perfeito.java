package lista1.questao12;

public class Perfeito {

	public static void main(String[] args) {
		
		int contador= 0;
		double numero=1;
		
		while(contador<=10) {
			
			if(perfeito(numero)!=0) {
				System.out.println(numero+" é um número perfeito");
				contador++;
			}
			numero++;
		}
	}
	
	public static double perfeito(double num) {
		
		double somador=0;
		int divisor=1;
		
		while(divisor<num) {
			
			if(num%divisor==0)
				somador+=divisor;
			
			divisor++;
		}
		
		if(somador==num)
			return num;
		else
			return 0;
	}
}
