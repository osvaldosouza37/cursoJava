package lista1.questao8;

public class EquacaoSegundoGrau {

	public static void main(String[] args) {
		
		int a=1,b=-2,c=1;
		double delta,x1,x2;
		
		delta = Math.pow(b,2) - 4*a*c;
		
		if(delta==0) {
			x1 = (-b + Math.sqrt(delta))/(2*a);
			
			System.out.println("A equação tem duas raízes iguais no valor: "+x1);
		}else if(delta==0) {
			x1 = (-b + Math.sqrt(delta))/(2*a);

			x2 = (-b - Math.sqrt(delta))/(2*a);
			
			System.out.println("A raíz x1 é: "+x1);
			System.out.println("A raíz x2 é: "+x2);
			
		}else {
			System.out.println("Não existe resolução no domínio dos reais.");
		} 
	}

}
