package lista1.questao1;

import javax.swing.JOptionPane;

public class Comparacao2 {

	public static void main(String[] args) {
		//criar as vari�veis
		int num1=0, num2=0,num3=0; 
		
		//criar o leitor
		num1 = Integer.parseInt(JOptionPane.showInputDialog("N�mero 1"));
		
		num2 = Integer.parseInt(JOptionPane.showInputDialog("N�mero 1"));
		
		num3 = Integer.parseInt(JOptionPane.showInputDialog("N�mero 1"));
		
		boolean igual = num1 == num2 && num2 == num3;
		
		boolean um = num1 > num2 && num1> num3;
		
		boolean dois = num2 > num3;

		if(igual)
			
			System.out.println("Todos os n�meros s�o iguais");
		
		else if(um)
			
			System.out.println("O maior n�mero �: "+num1);
		
		else if(dois)
			
			System.out.println("O maior n�mero �: "+num2);
		
		else
			
			System.out.println("O maior n�mero �: "+num3);
	}
}
