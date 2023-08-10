package com.springjwt.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.springjwt.entities.Customer;
import com.springjwt.exception.ErrorDetails;
import com.springjwt.exception.ResourceNotFoundException;
import com.springjwt.services.auth.CustomerService;

import ch.qos.logback.core.spi.ErrorCodes;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("sunbase/portal/api/assignment.jsp")
public class CustomerController
{
	@Autowired
	private CustomerService customerSer;
	
	@PostMapping("create")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer)
	{
		Customer savecustomer=customerSer.createCustomer(customer);
		System.out.println("CREATE : " + savecustomer);
		return new ResponseEntity<>(savecustomer,HttpStatus.CREATED);
	}
	
	@GetMapping("get_customer_list")
	public ResponseEntity<List<Customer>> getAllCustomers()
	{
		List<Customer> cu=customerSer.get_Customer_list();
		
		return new ResponseEntity<>(cu,HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomerByid(@PathVariable("id") Long cid)
	{
		customerSer.deleteCustomerById(cid);
		return new ResponseEntity<>("succfully deleted",HttpStatus.OK);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody @Valid  Customer customer, @PathVariable("id")long cid)
	{
		customer.setId(cid);
		Customer uci=customerSer.updateCustomer(customer);		
		return new ResponseEntity<>(uci,HttpStatus.OK);
	}
	

	
}
