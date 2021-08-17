package com.xworkz.jdbc.customer.tester;

import com.xworkz.jdbc.customer.constant.Education;
import com.xworkz.jdbc.customer.dao.CustomerDAO;
import com.xworkz.jdbc.customer.dao.CustomerDAOImpl;
import com.xworkz.jdbc.customer.dto.CustomerDTO;
import com.xworkz.jdbc.customer.service.CustomerService;
import com.xworkz.jdbc.customer.service.CustomerServiceImpl;

public class CustomerInsertTester {

	public static void main(String[] args) {
		CustomerDTO cust = new CustomerDTO("Raksha","Bangalore","Bangalore","Nagarbhavi",false,3442222,Education.BE);
		CustomerDTO cust1 = new CustomerDTO("Sahana","Tumkur","Bangalore","Jayanagar",false,32345668,Education.BE);
		CustomerDTO cust2 = new CustomerDTO("Teju","bagalokot","Belgavi","Peenya",false,323456679,Education.MCA);
		CustomerDTO cust3 = new CustomerDTO("Dhanya","Shivmoga","Bagalkot","ZantaBazar",false,323456675,Education.MBA);
		
		CustomerDAO dao = new CustomerDAOImpl();
		CustomerService service = new CustomerServiceImpl();
		String save = service.validAndSave(cust3);
		System.out.println(save);
		String save1 = service.validAndSave(cust2);
		System.out.println(save1);
		String save2 = service.validAndSave(cust1);
		System.out.println(save2);
		String save3 = service.validAndSave(cust);
		System.out.println(save3);
		 dao.save(cust3);
		 dao.save(cust2);
		 dao.save(cust1);
		 dao.save(cust);

	}

}
