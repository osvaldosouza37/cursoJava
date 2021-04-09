package lista1.questao11;

public class Fatorial {

	public static void main(String[] args) {
		
		System.out.println(fatorial(5));

	}

	
	public static double fatorial(int num) {
		
		int fat = num;
		
		while(fat>1) {
			
			fat--;
			
			num*=(fat);
			
		}
		
		return num;
	}
}
