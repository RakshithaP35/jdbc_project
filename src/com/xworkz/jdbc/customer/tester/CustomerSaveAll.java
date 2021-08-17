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

		CustomerDTO cust = new CustomerDTO("Raksha","Bangalore","Bangalore","Nagarbhavi",false,3442222,Education.BE);
		CustomerDTO cust1 = new CustomerDTO("Dhanya","Shivmoga","Bagalkot","ZantaBazar",false,323456675,Education.MBA);
		CustomerDTO cust2 = new CustomerDTO("Teju","bagalokot","Belgavi","Peenya",false,323456679,Education.MCA);
		CustomerDTO cust3 = new CustomerDTO("Shantanu", "banglore", "Maharastra", "fde",false, 1245789354, Education.MCA);

		Collection<CustomerDTO> col = Arrays.asList(cust, cust1, cust2, cust3);
		service.ValidateAndSaveAll(col);
		System.out.println(col);

	}

}
