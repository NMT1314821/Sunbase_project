package com.springjwt.services.jwt;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjwt.entities.Customer;
import com.springjwt.repositories.CustomerRepository;
import com.springjwt.services.auth.CustomerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public Customer createCustomer(Customer customer) 
	{
		return customerRepo.save(customer);
	}

	@Override
	public List<Customer> get_Customer_list() 
	{
		 return customerRepo.findAll();
		
	}

	@Override
	public void deleteCustomerById(Long cid) 
	{
		customerRepo.deleteById(cid);		
	}

	@Override
	public Customer updateCustomer(Customer customer) 
	{
		Customer ecustomer=customerRepo.findById(customer.getId()).get();
		ecustomer.setFirst_name(customer.getFirst_name());
		ecustomer.setLast_name(customer.getLast_name());
		ecustomer.setStreet(customer.getStreet());
		ecustomer.setAddress(customer.getAddress());
		ecustomer.setCity(customer.getCity());
		ecustomer.setState(customer.getState());
		ecustomer.setEmail(customer.getEmail());
		ecustomer.setPhone(customer.getPhone());		
		Customer updatecust=customerRepo.save(ecustomer);		
		return updatecust;
	}

}
