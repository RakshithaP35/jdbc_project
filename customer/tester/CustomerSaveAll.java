package com.xworkz.jdbc.customer.tester;

import java.util.Arrays;
import java.util.Collection;

import com.xworkz.jdbc.customer.constant.Education;
import com.xworkz.jdbc.customer.dto.CustomerDTO;
import com.xworkz.jdbc.customer.service.CustomerService;
import com.xworkz.jdbc.customer.service.CustomerServiceImpl;

public class CustomerSaveAll {

	public static void main(String[] args) {
		CustomerService service = new CustomerServiceImpl();

		CustomerDTO cust = new CustomerDTO("Sahana", "Tumkur", "Banglore", "vani vilas nilaya tumkur", false,
				1245789635, Education.BE);
		CustomerDTO cust1 = new CustomerDTO("Teju", "Dahrwad", "Tumkur", "Dharwad near Vidya Nagar", false, 1245789625,
				Education.BE);
		CustomerDTO cust2 = new CustomerDTO("Anusha", "Banglore", "AndhraPradesh", "Anusha nilaya near Charminar",
				false, 1245878545, Education.MBA);
		CustomerDTO cust3 = new CustomerDTO("Harsha", "banglore", "Hydrebad", "Hydrebad near KVR Botanical Garden",
				false, 1245789354, Education.MCA);

		Collection<CustomerDTO> col = Arrays.asList(cust, cust1, cust2, cust3);
		service.ValidateAndSaveAll(col);
		System.out.println(col);

	}

}
