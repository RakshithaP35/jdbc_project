package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTester {

	public static void main(String[] args) {
		String usernaame = "root";
		String password = "rakshitha3518";
		String urls = "jdbc:mysql://localhost:3306/jdbc_program";
		String fqnOdDriverImpl = "com.mysql.cj.jdbc.Driver";
		Connection connection = null;
		try {
			Class.forName(fqnOdDriverImpl);
			/*Connection*/ connection = DriverManager.getConnection(urls, usernaame, password);
			
			String query = "insert into insureance_details values(1,'raksh','Health Insurance',3,'LIC',45252)";
			Statement statement = connection.createStatement();
			statement.execute(query);
			System.out.println(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
