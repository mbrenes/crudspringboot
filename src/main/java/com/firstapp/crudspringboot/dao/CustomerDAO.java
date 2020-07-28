package com.firstapp.crudspringboot.dao;

import com.firstapp.crudspringboot.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerDAO extends CrudRepository<Customer,Integer> {
    @Override
    List<Customer> findAll();

    @Override
    Optional<Customer> findById(Integer customerId);


}
