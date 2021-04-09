package lista1.questao6;

public class EnesimoPrimo {

	public static void main(String[] args) {
		
		int num = 1,contador=1;
		
		while(contador<=1001) {
			if(primo(num)!=0) {
				System.out.println(num);
				contador++;
			}	
			num++;			
		}
	}
	
	public static int primo(int num) {
		
		int contador=0;
		
		for (int i = 1; i <=num; i++) {
			
			if(num%i==0)
				contador++;
		}
		
		if(contador==2)
			return num;
		else
			return 0;
	}

}
