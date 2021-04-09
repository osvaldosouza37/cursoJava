package lista1.questao7;

public class ListaPrimos {

	public static void main(String[] args) {
		
		int num = 1,contador=1;
		
		System.out.println("+---------------------------+");
		System.out.println("|	Números primos 	    |");
		System.out.println("+---------------------------+");
		while(contador<=200) {
			if(primo(num)!=0) {
				System.out.println(" "+contador+"º:"+"\t"+num);
				contador++;
				System.out.println("-----------------------------");
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
