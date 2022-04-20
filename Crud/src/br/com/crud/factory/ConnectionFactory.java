package br.com.crud.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "MySQL123456";
	private static final String DATA_BASE = "jdbc:mysql://localhost:3306/crud";
	
	public static Connection createConnectionToMySQL() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATA_BASE, USERNAME, PASSWORD);
		
		return connection;
	}
	

	public static void main(String[] args) throws Exception {
		
		Connection con = createConnectionToMySQL();
		
		if (con != null) {
			System.out.println("Conexão obtida com sucesso" + con);
			con.close();	
		}
		
	}

}
