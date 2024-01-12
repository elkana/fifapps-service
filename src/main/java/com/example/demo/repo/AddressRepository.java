package com.example.demo.repo;

import org.springframework.data.repository.ListCrudRepository;

import com.example.demo.model.Address;

public interface AddressRepository extends ListCrudRepository<Address, Integer>{

}
