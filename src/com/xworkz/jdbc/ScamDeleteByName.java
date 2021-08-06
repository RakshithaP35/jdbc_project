package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ScamDeleteByName {
	public static void main(String[] args) {
		String username = "root";
		String password = "rakshitha3518";
		String url = "jdbc:mysql://localhost:3306/jdbc_program";
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";

		Connection connection = null;
		try {
			Class.forName(fqnOfDriverImpl);
			connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			String delete = "delete from scam_table where s_name = 'SandalWoodDrugScam' ";
			statement.execute(delete);

			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
}
}
