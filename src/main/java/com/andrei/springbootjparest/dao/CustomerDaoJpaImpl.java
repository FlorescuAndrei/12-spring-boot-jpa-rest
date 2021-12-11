package com.andrei.springbootjparest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.andrei.springbootjparest.entity.Customer;





@Repository
public class CustomerDaoJpaImpl implements CustomerDAO {
	private EntityManager entityManager;
	
	@Autowired
	public CustomerDaoJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Customer> findAll() {
		Query query = entityManager.createQuery("from Customer");
		
		
		//execute query
		List<Customer> customers = query.getResultList();
		
		
		return customers;
	}

	@Override
	public Customer findById(int id) {
		
		Customer customer = entityManager.find(Customer.class, id);
		
		return customer;
	}

	@Override
	public void save(Customer customer) {
		
		Customer dbCustomer = entityManager.merge(customer);

		//update with id from db...so  we can get generated id for save/insert
		customer.setId(dbCustomer.getId());
	}

	@Override
	public void deleteById(int id) {
		Query query = entityManager.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();

	}

}
