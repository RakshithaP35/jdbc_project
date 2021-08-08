package com.xworkz.jdbc.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ScamTester {

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(ScamConstant.username, ScamConstant.password,
				ScamConstant.url)) {
			

			String query = "select * from scam where s_amount > 200000";
			Statement stm = connection.createStatement();
			stm.execute(query);
			ResultSet resultset = stm.getResultSet();
			ScamDTO dto = null;

			List<ScamDTO> user = new ArrayList<ScamDTO>();
			while (resultset.next()) {
				ScamDTO users = new ScamDTO();
				users.setS_amount(resultset.getInt("s_amount"));

				String name = resultset.getString("s_name");
				int id = resultset.getInt("s_id");
				String type = resultset.getString("s_type");
				int year = resultset.getInt("s_year");
				String by = resultset.getString("s_by");
				int amount = resultset.getInt("s_amount");
				String location = resultset.getString("s_location");

				System.out.println(name);
				dto = new ScamDTO(name, id, type, year, by, amount, location);
				System.out.println(dto);
				user.add(users);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
