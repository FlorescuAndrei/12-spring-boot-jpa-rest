package com.andrei.springbootjparest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrei.springbootjparest.entity.Customer;
import com.andrei.springbootjparest.service.CustomerService;





@RestController
@RequestMapping("/api")
public class CustomerRestController {

//	@Autowired - Autowired in constructor like  in course example (optional)
	private CustomerService customerService;
	
	@Autowired
	public CustomerRestController(@Qualifier("customerServiceHibernateAndJpaImpl")CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/customers")
	public List<Customer>findAll(){
		
		return customerService.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public Customer findById(@PathVariable int id){
		
		Customer customer =  customerService.findById(id);
		
		if(customer == null) {
			throw new RuntimeException("Customer id not found = " + id);
		}
		return customer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		customer.setId(0);
		
		customerService.save(customer);
		
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.save(customer);
		
		return customer;
	}
	
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {
		Customer customer = customerService.findById(id);
		
		if(customer == null) {
			throw new RuntimeException("Customer id not found -" + id);
		
		}
		
		customerService.deleteById(id);
		
		return "Deleting customer id - " + id;
	}
	
	
	
	
	
	
}
