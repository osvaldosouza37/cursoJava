package lista1.questao9;

public class Inverter2 {

	public static void main(String[] args) {
		
		char letra[] = {'a','e','i','o','u'};
		
		char invertido[] = new char[letra.length];
		
		for (int i = 0; i < letra.length; i++) {
			
			invertido[(letra.length-i)-1] = letra[i];	
		}
		
		for(char vogal : invertido) {
			System.out.println(vogal);
		}
	}

}
