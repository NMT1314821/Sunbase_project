package com.springjwt.services.auth;

import java.util.List;

import com.springjwt.entities.Customer;

public interface CustomerService 
{
	Customer createCustomer(Customer customer);
	
	List<Customer> get_Customer_list();
	
	void deleteCustomerById(Long cid);
	
	Customer updateCustomer(Customer customer);
}
