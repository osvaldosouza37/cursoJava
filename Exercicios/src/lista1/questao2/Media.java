package lista1.questao2;

import java.util.Scanner;

public class Media {

	public static void main(String[] args) {
		
		//criar as variáveis
				int num1=0, num2=0,num3=0; 
				
				//criar o leitor
				Scanner leitor = new Scanner(System.in);
				
				System.out.println("Digite o 1º número");
				
				num1 = leitor.nextInt();
				
				System.out.println("Digite o 2º número");
				
				num2 = leitor.nextInt();
				
				System.out.println("Digite o 3º número");
				
				num3 = leitor.nextInt();
		
				double resultado = (double)(num1+num2+num3)/3;
				
				System.out.println("A média é: "+resultado);
				
	}

}
