package com.andrei.springbootjparest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrei.springbootjparest.entity.Customer;




//for Spring Data JPA
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	//<Entity type, PK type>
}
