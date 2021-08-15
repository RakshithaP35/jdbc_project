package com.xworkz.jdbc.customer.service;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.jdbc.customer.dto.CustomerDTO;

public interface CustomerService {
	String validAndSave(CustomerDTO dto);
	void ValidateAndSaveAll(Collection<CustomerDTO> collection);

	Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate);

	Collection<CustomerDTO> findAll();

	Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate);

	int total();

	Collection<CustomerDTO> findAllSortByNameDesc();

}
