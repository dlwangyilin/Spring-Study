package com.yilin.springdemo.service;

import java.util.List;

import com.yilin.springdemo.model.Customer;

public interface CustomerService {

	List<Customer> getCustomers();

	void saveCustomer(Customer theCustomer);

	Customer getCustomer(int theId);

	void deleteCustomer(int theId);
	
}
