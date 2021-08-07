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
			String scam5 = "insert into scam_table values(15,'SandalWoodDrugScam','Drug scam',2019,'KannadaCinemaIndustry',100000,'Karnataka','Kannada Film indystry is segment dedicated to the production')";
			String scam6 = "Insert into scam_table values(16,'PNB scam','Abdcanded Scam',2016,'VijayMalya',900000,'Banglore','Anscond by taking loan')";
			String scam7 = "insert into scam_table values(17,'National Bank scam', 'bank scam',2018,'Indian bank'110000600,'punjab','The FIR said that Rotomac diverted the loans to a fictitious company')";
			String scam8 = "insert into scam_table values(18,'Noida Ponzi scam','InfoSoultion',2017,'Anubhav Mittal',1200000,'Maharastra','suspicious transactions by nearly 200 gold and diamond dealers')";
			String scam9 = "Insert into scam_table values(19,'Gujarat fisheries scam','fishing',2015,' Purshottam Solanki',200090,'Gujarat','illegally granting fishing contracts for 58 reservoirs')";
			String scam10= "Insert into scam_table values(20,'Taxi/ Auto scam','transport scam',2020,'trans dept',5000000,'India',' the taxi meter is broken and ask for an inflated flat fare')";
			String scam11= "Insert into scam_table values(21,'unofficial tour scam','tourist scam',2018,'visiters',34000,'India','These guides will often not show you all round a location')"	;
			String scam12= "Insert into scam_table values(22,'Fast-track',brand company scam',2020,'Anounymus',20000,'mumbai','They will take your money and vanish into thin air')";
			String scam13= "Insert into scam_table values(23,'Temple donation scam','temple scam',2019,'people',300020,'tamil nadu','claim to be temple officials and ask for a hefty donation')";
			String scam14= "Insert into scam_table values(24,'Fake money scam',money scam',2018,'fraud',500000,'kolkata','swap with a fake note that he already has and claim that the bill you handed over to him was fake')";
			String scam15= "Insert into scam_table values(25,'Pre-paid taxi scam','trans scam',2017,'tourist',30000,'kerala','During the journey, the taxi driver will tell you that the area that leads to the hotel is blocked')";
			String scam16= "Insert into scam_table values(26,'SIM card scam','sim scam',2018,'people',20000,'karnataka','they will either hand you over the used SIM card')";
			String scam17= "Insert into scam_table values(27,'Free gifts','website scam',2020,'users',10000,'karnataka','There ain’t no such thing as a free lunch')";
			String scam18= "Insert into scam_table values(28,'Pickpockets scam','roberry',2016,'citizen',10000,'tamil nadu','Pickpockets work in teams, and use distraction tactics to pick your pocket')";
			String scam19= "Insert into scam_table values(29,'Stock Market Scam','marketing scam',2001','Ketan Parekh',20000,'mumbai',' Involvement in the Indian stock market manipulation scam that occurred from late 1998 to 2001')";
			String scam20= "Insert into scam_table values(30,'Delhi power scam','power scam',2019,'Reliance Anil Dhirubhai Ambani','dehli',' accused of inflating their rates by almost ₹8,000 crore, and rates in the city')";
															
			statement.execute(scam1);
			statement.execute(scam2);
			statement.execute(scam3);
			statement.execute(scam4);
			statement.execute(scam5);
			statement.execute(scam6);
			statement.execute(scam7);
			statement.execute(scam8);
			statement.execute(scam9);
			statement.execute(scam10);
			statement.execute(scam11);
			statement.execute(scam12);
			statement.execute(scam13);
			statement.execute(scam14);
			statement.execute(scam15);
			statement.execute(scam16);
			statement.execute(scam17);
			statement.execute(scam18);
			statement.execute(scam19);
			statement.execute(scam20);
			
		
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
