package lista1.questao2;

import java.util.Scanner;

public class Media {

	public static void main(String[] args) {
		
		//criar as vari�veis
				int num1=0, num2=0,num3=0; 
				
				//criar o leitor
				Scanner leitor = new Scanner(System.in);
				
				System.out.println("Digite o 1� n�mero");
				
				num1 = leitor.nextInt();
				
				System.out.println("Digite o 2� n�mero");
				
				num2 = leitor.nextInt();
				
				System.out.println("Digite o 3� n�mero");
				
				num3 = leitor.nextInt();
		
				double resultado = (double)(num1+num2+num3)/3;
				
				System.out.println("A m�dia �: "+resultado);
				
	}

}
