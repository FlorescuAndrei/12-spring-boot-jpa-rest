package com.andrei.springbootjparest.dao;

import java.util.List;

import com.andrei.springbootjparest.entity.Customer;




public interface CustomerDAO {

	public List<Customer> findAll();
	
	public Customer findById(int id);
	
	public void save(Customer employee);
	
	public void deleteById(int id);
}


