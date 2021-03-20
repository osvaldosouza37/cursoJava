package aulaOnline;

public class Tarefa {

	public static void main(String[] args) {
		
		
		int contador = 1;
		double somador = 0;
		
		for(;contador<=100;contador++) {
			
			somador+= (double)1/contador;
			
		}
		
		System.out.println(somador);
	}

}
