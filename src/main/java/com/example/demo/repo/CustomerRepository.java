package com.example.demo.repo;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.example.demo.model.Customer;

public interface CustomerRepository extends ListCrudRepository<Customer, Integer>{
	List<Customer> findByNameContaining(String name);
}
