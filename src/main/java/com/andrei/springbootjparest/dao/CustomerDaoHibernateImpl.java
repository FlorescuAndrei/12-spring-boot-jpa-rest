package com.andrei.springbootjparest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.andrei.springbootjparest.entity.Customer;






@Repository
public class CustomerDaoHibernateImpl implements CustomerDAO {
	
	//define field for entitymanager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired  //default when is only one constructor
	public CustomerDaoHibernateImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public List<Customer> findAll() {
		//get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
		
		
	}

	@Override
	public Customer findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Customer customer = session.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void save(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(customer);
		
	}

	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		
		query.executeUpdate(); 
		
	}

}
