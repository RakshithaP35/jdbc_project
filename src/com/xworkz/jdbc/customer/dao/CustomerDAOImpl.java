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
		Connection temp = null;
		try(Connection connection = DriverManager.getConnection(URL,USERNAME,SECRET)){
			temp = connection;
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
			temp.rollback();
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		}
		return aiId;
	}

	@Override
	public void saveAll(Collection<CustomerDTO> collection) {
		collection.stream().forEach(dto->save(dto));

		}

	private CustomerDTO ResultSetValues(ResultSet res) throws SQLException{
		int c_id = res.getInt("c_id");
		String c_name = res.getString("c_name");
		String c_from = res.getString("c_from");
		String c_to = res.getString("c_to");
		boolean c_married = res.getBoolean("c_married");
		String c_address = res.getString("c_address");
		int c_passportNo = res.getInt("c_passportNo");
		String c_education = res.getString("c_education");
		CustomerDTO dto = new CustomerDTO(c_name, c_from, c_to, c_address, c_married, c_passportNo,
				Education.valueOf(c_education));
		dto.setId(c_id);
		return dto;
	}


	
	@Override
	public Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate) {
		System.out.println("Find one from table using predicate");
		Optional<CustomerDTO> optional = Optional.empty();
		try (Connection connection = DriverManager.getConnection(URL,USERNAME,SECRET)) {
			String query = "select * from customer_table";
			PreparedStatement stm = connection.prepareStatement(query);
			ResultSet resultSet = stm.executeQuery();
			while (resultSet.next()) {
				CustomerDTO dto = ResultSetValues(resultSet);
				if (predicate.test(dto)) {
					optional = Optional.of(dto);
					
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
			String query = "select * from customer_table";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

			CustomerDTO dto = ResultSetValues(resultSet);
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
		Collection<CustomerDTO> col = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(URL,USERNAME,SECRET)) {
			String query = "select * from customer_table";
			PreparedStatement stm = connection.prepareStatement(query);
			ResultSet resultSet = stm.executeQuery();
			while (resultSet.next()) {
				CustomerDTO dto = ResultSetValues(resultSet);
			
				if (predicate.test(dto)) {
					col.add(dto);
					
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return col;
	}


	@Override
	public Collection<CustomerDTO> findAllSortByNameDesc() {
		System.out.println("Find all data's from table name in decending order");
		Collection<CustomerDTO> collection = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(URL,USERNAME,SECRET)) {
			String query = "select * from customer_table order by c_name desc";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				CustomerDTO dto = ResultSetValues(resultSet);

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

			String count = "select * from customer_table";

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
