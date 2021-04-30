package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

		//Criar método getConnection que retorna uma Connection
		
		public static Connection getConnection(){
			//nome do driver.
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				//endereco e parametros de conexão com o banco.
				return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_projeto?useTimezone=true&serverTimezone=UTC","root","123456");
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
			} 
			
		}
	
}
