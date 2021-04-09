package lista1.questao5;

public class Fibonacci {

	public static void main(String[] args) {
		
		int a=1,b=0,c=0,somador=0;
		
		while(c<5000) {
			
			System.out.println(c);
			
			if(c%2==0)
				somador+=c;
			
			c = a + b;
			a = b;
			b = c;
		}
		System.out.println(somador);
	}
}
