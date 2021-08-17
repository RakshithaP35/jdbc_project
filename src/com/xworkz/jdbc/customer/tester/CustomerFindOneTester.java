package com.xworkz.jdbc.customer.tester;

import java.util.Optional;

import com.xworkz.jdbc.customer.dao.CustomerDAO;
import com.xworkz.jdbc.customer.dao.CustomerDAOImpl;
import com.xworkz.jdbc.customer.dto.CustomerDTO;

public class CustomerFindOneTester {

	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAOImpl();
		Optional<CustomerDTO> opt = dao.findOne((a) ->a.getName().equals("Raksha"));
		if (opt.isPresent()) {
			CustomerDTO dto = opt.get();
			System.out.println(dto);
		}

	}

}
