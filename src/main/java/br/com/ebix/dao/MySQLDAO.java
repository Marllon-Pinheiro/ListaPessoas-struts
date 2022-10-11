package br.com.ebix.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAO {
	
	public MySQLDAO() {
		
	}

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			return DriverManager
					.getConnection("jdbc:mysql://localhost:3306/listapessoas?useTimezone=true&serverTimezone=UTC", "root", "root");
		} catch(SQLException ex) {
			throw new RuntimeException("Erro ao se conectar com o banco", ex);
		}
		
	}
}
