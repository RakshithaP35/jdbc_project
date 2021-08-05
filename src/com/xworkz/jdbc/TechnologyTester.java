package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TechnologyTester {

	public static void main(String[] args) {
		String username = "root";
		String password = "rakshitha3518";
		String url = "jdbc:mysql://localhost:3306/jdbc_program";
		String fqnOdDriverImpl = "com.mysql.cj.jdbc.Driver";

		Connection connection = null;

		try {
			Class.forName(fqnOdDriverImpl);
			connection = DriverManager.getConnection(url, username, password);

			String query = "insert into technology values(1,'Core Java',20,25000.00,6)";
			String query1 = "insert into technology values(2,'artificial intelligence',10,35000.00,2)";
			String query2 = "insert into technology values(3,'C++',12,20000.00,3)";
			String query3 = "insert into technology values(4,'Python',40,5000.00,4)";
			String query4 = "insert into technology values(5,'Machine learning',11,12000.00,7)";

			Statement statement = connection.createStatement();

			statement.execute(query);
			statement.execute(query1);
			statement.execute(query2);
			statement.execute(query3);
			statement.execute(query4);

			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}
