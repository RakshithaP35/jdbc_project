package com.xworkz.jdbc.customer.tester;

import com.xworkz.jdbc.customer.dao.CustomerDAO;
import com.xworkz.jdbc.customer.dao.CustomerDAOImpl;

public class CustomerTotal {

	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAOImpl();
		  System.out.println(dao.total());

		  

	}

}
