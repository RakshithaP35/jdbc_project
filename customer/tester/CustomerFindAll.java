package com.xworkz.jdbc.customer.tester;

import com.xworkz.jdbc.customer.dao.CustomerDAO;
import com.xworkz.jdbc.customer.dao.CustomerDAOImpl;
import com.xworkz.jdbc.customer.service.CustomerService;
import com.xworkz.jdbc.customer.service.CustomerServiceImpl;

public class CustomerFindAll {

	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAOImpl();
		CustomerService service = new CustomerServiceImpl();
		service.findAll();
		System.out.println(dao.findAll());
		

	}

}
