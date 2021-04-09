package lista1.questao9;

public class Inverter {

	public static void main(String[] args) {
		
		int numeros[] = {1,2,3,4,5,6,7,8,9};
		
		int invertido[] = new int[numeros.length];
		
		for (int i = 0; i < numeros.length; i++) {
			
			invertido[(numeros.length-i)-1] = numeros[i];	
		}
		
		for(int numero : invertido) {
			System.out.println(numero);
		}
	}

}
