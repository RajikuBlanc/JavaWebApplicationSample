package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		final String URL = "jdbc:postgresql://localhost:5432/tododb";
		final String USER = "rajiku";
		final String PASSWORD = "Ryochi0730";
		Class.forName("org.postgresql.Driver");

		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		return con;
		
	}
}
