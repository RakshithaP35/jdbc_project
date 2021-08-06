package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ScamInsertTester {

	public static void main(String[] args) {
		String username = "root";
		String password = "rakshitha3518";
		String url = "jdbc:mysql://localhost:3306/jdbc_program";
		String fqnOdDriverImpl = "com.mysql.cj.jdbc.Driver";

		Connection connection = null;

		try {
			Class.forName(fqnOdDriverImpl);
			connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			
			String scam1 = "insert into scam_table values(11,'KeralaGoldSmuggling','GoldSmuggling',2020,'Kerala govt',10000,'Kerala','carring baggage')";
			String scam2 = "insert into scam_table values(12,'TRP scam','TRP',2020,'national tv',10000,'Mumbai','Files Charge sheet')";
			String scam3 = "insert into scam_table values(13,'land Scam','Land scam',2020,'Roshini',25000,'JammuKashmir','Accuried land ofJ&K')";
			String scam4 = "insert into scam_table values(14,'Adya scam','Trading Scam',2019,'Amrapali',200000,'India','fraud investors')";
			String scam5 = "insert into scam_table values(15,'SandalWoodDrugScam','Drug scam',2019,'KannadaCinemaIndustry',100000,'Karnata','Kannada Film indystry is segment dedicated to the production')";
			String scam6 = "Insert into scam_table values(16,'PNB scam','Abdcanded Scam',2016,'VijayMalya',900000,'Banglore','Anscond by taking loan')";

			statement.execute(scam1);
			statement.execute(scam2);
			statement.execute(scam3);
			statement.execute(scam4);
			statement.execute(scam5);
			statement.execute(scam6);
		
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
