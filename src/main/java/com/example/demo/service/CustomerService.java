package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;

@Service
public class CustomerService {

	@Autowired CustomerRepository repoCustomer;
	
	public Customer add(Customer data) {
		return repoCustomer.save(data);
	}

	public List<Customer> getAll() {
		return repoCustomer.findAll();
	}

	public List<Customer> addCustomers(List<Customer> customers) {
		return repoCustomer.saveAll(customers);
	}
}
