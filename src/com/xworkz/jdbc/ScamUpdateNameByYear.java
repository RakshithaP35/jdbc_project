package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ScamUpdateNameByYear {

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
			String update = "update scam_table set s_name='PNB scam' where s_year =2019";
			statement.execute(update);

			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
