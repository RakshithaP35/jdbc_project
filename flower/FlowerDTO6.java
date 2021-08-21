package com.xworkz.jdbc.flower;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FlowerDTO6 {

	public static void main(String[] args) {
		String username = "root";
		String password = "rakshitha3518";
		String url = "jdbc:mysql://localhost:3306/flowers";
		String fqnOdDriverImpl = "com.mysql.cj.jdbc.Driver";
		
		Connection connection = null;
		
		try {
			Class.forName(fqnOdDriverImpl);
			connection = DriverManager.getConnection(url, username, password);
			String query = "insert into flowers_table2 values(6, 'Orchid','Yellow',100.000,false,'Gifting','Rose','wild flower',4,1)";
			Statement statement = connection.createStatement();
			statement.execute(query);
			System.out.println(connection);
		}catch (SQLException e) {
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
