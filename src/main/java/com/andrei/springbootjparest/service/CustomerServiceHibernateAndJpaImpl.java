package com.andrei.springbootjparest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andrei.springbootjparest.dao.CustomerDAO;
import com.andrei.springbootjparest.entity.Customer;




@Service
public class CustomerServiceHibernateAndJpaImpl implements CustomerService {
	
	//for Hibernate and JPA
	private CustomerDAO customerDAO;
	
	@Autowired
	public CustomerServiceHibernateAndJpaImpl(@Qualifier("customerDaoHibernateImpl")CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	

	@Override
	@Transactional
	public List<Customer> findAll() {
		
		
		return customerDAO.findAll();
		
	}

	@Override
	@Transactional
	public Customer findById(int id) {


		return customerDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerDAO.save(customer);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		customerDAO.deleteById(id);

	}

}
