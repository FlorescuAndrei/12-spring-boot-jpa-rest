package com.andrei.springbootjparest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrei.springbootjparest.dao.CustomerRepository;
import com.andrei.springbootjparest.entity.Customer;




@Service
public class CustomerServiceSpringDataJpaImpl implements CustomerService {
	
	
	//for Spring Data JPA
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceSpringDataJpaImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
//	@Transactional - by default with Spring Data JPA
	public List<Customer> findAll() {
		
		return customerRepository.findAll();

		
	}

	@Override
	public Customer findById(int id) {
		Optional<Customer> result = customerRepository.findById(id);
		Customer customer = null;
		if(result.isPresent()) {
			customer = result.get();
			return customer;
		}else {
			throw new RuntimeException("Did not find customer id - " + id); 
		}
		
		
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);

	}

	@Override
	public void deleteById(int id) {
		customerRepository.deleteById(id);

	}

}
