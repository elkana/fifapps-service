package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.StructureCreditDto;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired CustomerService serviceCustomer;
	@Autowired RestTemplate restTemplate;
	
	@GetMapping("/list")
	public ResponseEntity<List<Customer>> getAll() {
		return ResponseEntity.ok(serviceCustomer.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer data){
		var newData = serviceCustomer.add(data);
		return ResponseEntity.ok(newData);
	}
	
	@PostMapping("/addCustomers")
	public ResponseEntity<List<Customer>> addCustomer(@RequestBody List<Customer> customers){
		var newData = serviceCustomer.addCustomers(customers);
		return ResponseEntity.ok(newData);
	}
	
	// call om-service/structurecredit
	@GetMapping("/structure_credits")
	public ResponseEntity<?> getStructureCredits() {
		var response = restTemplate.getForEntity("http://localhost:1112/om/structure-credit/list", StructureCreditDto[].class);
		return ResponseEntity.ok(response.getBody());
	}
}
