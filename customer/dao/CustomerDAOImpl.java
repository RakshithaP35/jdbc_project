package com.xworkz.jdbc.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import static com.xworkz.jdbc.customer.constant.CustomerConstant.*;
import com.xworkz.jdbc.customer.constant.Education;
import com.xworkz.jdbc.customer.dto.CustomerDTO;

public class CustomerDAOImpl implements CustomerDAO{
	@Override
	public int save(CustomerDTO dto) {
		System.out.println("saving dto in database");
		int aiId =0;
		Connection tempcon = null;
		try(Connection connection = DriverManager.getConnection(URL,USERNAME,SECRET)){
			tempcon = connection;
			connection.setAutoCommit(false);
			String query = "insert into customer(c_name,c_from,c_to,c_address,c_married,c_passportNo,c_education)values "
					+ "(?,?,?,?,?,?,?)";
			PreparedStatement stm = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ResultSet resultSet = stm.getGeneratedKeys();
			stm.setString(1, dto.getName());
			stm.setString(2, dto.getFrom());
			stm.setString(3, dto.getTo());
			stm.setString(4, dto.getAddress());
			stm.setBoolean(5, dto.isMarried());
			stm.setInt(6, dto.getPassportNo());
			stm.setString(7, dto.getEducation().toString());
			if(resultSet.next()) {
				aiId = resultSet.getInt(aiId);
				}
			System.out.println(aiId);
			dto.setId(aiId);
			stm.execute();
			connection.commit();
			System.out.println(dto);
			
		} catch (SQLException e) {
			e.printStackTrace();
		try {
			tempcon.rollback();
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		}
		return aiId;
	}

	@Override
	public void saveAll(Collection<CustomerDTO> collection) {
		System.out.println("ALL DTO is Saving in DataBase");
		Collection<CustomerDTO> col = new ArrayList<CustomerDTO>();
		int aid = 0;
		Connection tempCon = null;
		try (Connection connection = DriverManager.getConnection(URL,USERNAME,SECRET)) {
			tempCon = connection;
			connection.setAutoCommit(false);
			String query = "insert into customer(c_name,c_from,c_to,c_address,c_married,c_passportNo,c_education) values (?,?,?,?,?,?,?)";
			PreparedStatement stm = connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
			collection.forEach(dto -> {
				int aild = 0;
				try {
					stm.setString(1, dto.getName());
					stm.setString(2, dto.getFrom());
					stm.setString(3, dto.getTo());
					stm.setString(4, dto.getAddress());
					stm.setBoolean(5, dto.isMarried());
					stm.setInt(6, dto.getPassportNo());
					stm.setString(7, dto.getEducation().toString());
					stm.execute();
					ResultSet resultset = stm.getGeneratedKeys();
					if (resultset.next()) {
						aild = resultset.getInt(1);
					}
					dto.setId(aild);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
			connection.commit();
			col.addAll(collection);
		} catch (SQLException e) {

			e.printStackTrace();
			try {
				tempCon.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

	}
	@Override
	public Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate) {
		System.out.println("Find one from table using predicate");
		Optional<CustomerDTO> optional = Optional.empty();
		try (Connection connection = DriverManager.getConnection(URL,USERNAME,SECRET)) {
			String query = "select * from customer";
			PreparedStatement stm = connection.prepareStatement(query);
			ResultSet resultSet = stm.executeQuery();
			while (resultSet.next()) {
				String c_name = resultSet.getString("c_name");
				String c_from = resultSet.getString("c_from");
				String c_to = resultSet.getString("c_to");
				boolean c_married = resultSet.getBoolean("c_married");
				String c_address = resultSet.getString("c_address");
				int c_passportNo = resultSet.getInt("c_passportNo");
				String c_education = resultSet.getString("c_education");
				CustomerDTO dto = new CustomerDTO(c_name, c_from, c_to, c_address, c_married, c_passportNo,
						Education.valueOf(c_education));
				if (predicate.test(dto)) {
					optional = Optional.of(dto);
					break;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return optional;
	}
	@Override
	public Collection<CustomerDTO> findAll() {
		System.out.println("Find all data's from table");
		Collection<CustomerDTO> collection = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(URL,USERNAME,SECRET)) {
			String query = "select * from customer";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int c_id = resultSet.getInt("c_id");
				String c_name = resultSet.getString("c_name");
				String c_from = resultSet.getString("c_from");
				String c_to = resultSet.getString("c_to");
				boolean c_married = resultSet.getBoolean("c_married");
				String c_address = resultSet.getString("c_address");
				int c_passportNo = resultSet.getInt("c_passportNo");
				String c_education = resultSet.getString("c_education");
				CustomerDTO dto = new CustomerDTO(c_name, c_from, c_to, c_address, c_married, c_passportNo,
						Education.valueOf(c_education));
				dto.setId(c_id);
				
				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}
	@Override
	public Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate) {
		System.out.println("Find All from table using predicate");
		int aid = 0;
		Collection<CustomerDTO> optional = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(URL,USERNAME,SECRET)) {
			String query = "select * from customer";
			PreparedStatement stm = connection.prepareStatement(query);
			ResultSet resultSet = stm.executeQuery();
			while (resultSet.next()) {
				String c_name = resultSet.getString("c_name");
				String c_from = resultSet.getString("c_from");
				String c_to = resultSet.getString("c_to");
				boolean c_married = resultSet.getBoolean("c_married");
				String c_resiadress = resultSet.getString("c_resiAdress");
				int c_passportNo = resultSet.getInt("c_passportNo");
				String c_education = resultSet.getString("c_education");
				CustomerDTO dto = new CustomerDTO(c_name, c_from, c_to, c_resiadress, c_married, c_passportNo,
						Education.valueOf(c_education));
				if (predicate.test(dto)) {
					optional.add(dto);
					break;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return optional;
	}


	@Override
	public Collection<CustomerDTO> findAllSortByNameDesc() {
		System.out.println("Find all data's from table name in decending order");
		Collection<CustomerDTO> collection = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(URL,USERNAME,SECRET)) {
			String query = "select * from customer order by c_name desc";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int c_id = resultSet.getInt("c_id");
				String c_name = resultSet.getString("c_name");
				String c_from = resultSet.getString("c_from");
				String c_to = resultSet.getString("c_to");
				boolean c_married = resultSet.getBoolean("c_married");
				String c_address = resultSet.getString("c_address");
				int c_passportNo = resultSet.getInt("c_passportNo");
				String c_education = resultSet.getString("c_education");
				CustomerDTO dto = new CustomerDTO(c_name, c_from, c_to, c_address, c_married, c_passportNo,
						Education.valueOf(c_education));
				dto.setId(c_id);

				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;

	}

	@Override
	public int total() {
		int value = 0;
		try (Connection connection = DriverManager.getConnection(URL,USERNAME,SECRET)) {

			String count = "select * from customer";

			Statement statement = connection.createStatement();
			statement.execute(count);
			ResultSet resultset = statement.getResultSet();
			int counts = 1;

			while (resultset.next()) {
				value = counts++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return value;
	}


}
