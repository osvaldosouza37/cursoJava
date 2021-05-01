package windowbuilder.janela;

import java.util.ArrayList;
import java.util.List;

public class teste {

	public static void main(String[] args) {
	
		ContatoDao dao = new ContatoDao();
		
		Contato c1 = new Contato();
		
		c1.setNome("Cloud");
		c1.setSobrenome("Striffe");
		c1.setIdade(37);
		c1.setTelefone("777777777");
		
		//dao.salvarDao(c1);
		
		/*
		List<Contato> contatos = new ArrayList<>();
		
		contatos = dao.consultarDao();
		
		
		for(Contato contato : contatos) {
			System.out.println(contato.getNome());
		}
		
		*/
	}

}
