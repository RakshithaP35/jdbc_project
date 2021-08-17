package com.xworkz.jdbc.customer.tester;

import java.util.Collection;


import com.xworkz.jdbc.customer.dto.CustomerDTO;
import com.xworkz.jdbc.customer.service.CustomerService;
import com.xworkz.jdbc.customer.service.CustomerServiceImpl;

public class CustomerFindAll {

	public static void main(String[] args) {
		
		CustomerService service = new CustomerServiceImpl();
		Collection<CustomerDTO> collection = service.findAll();
		collection.forEach(r->System.out.println(r));
		

	}

}
