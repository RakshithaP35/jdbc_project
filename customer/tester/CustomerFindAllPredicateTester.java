package com.xworkz.jdbc.customer.tester;

import java.util.Collection;

import com.xworkz.jdbc.customer.dao.CustomerDAO;
import com.xworkz.jdbc.customer.dao.CustomerDAOImpl;
import com.xworkz.jdbc.customer.dto.CustomerDTO;

public class CustomerFindAllPredicateTester {

	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAOImpl();
		Collection<CustomerDTO> col = dao.findAll(n -> n.getName().equals("Sahana"));
		col.forEach(k -> System.out.println(k));


	}

}
