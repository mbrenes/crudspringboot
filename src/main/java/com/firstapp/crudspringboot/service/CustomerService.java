package com.firstapp.crudspringboot.service;

import com.firstapp.crudspringboot.dao.CustomerDAO;
import com.firstapp.crudspringboot.exception.CustomerNotFoundException;
import com.firstapp.crudspringboot.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer){
       return customerDAO.save(customer);
    }

    public List<Customer> getCustomerList (){
       return customerDAO.findAll();
    }

    public Customer getCustomer(int customerId) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
        if (!optionalCustomer.isPresent()){
          throw new CustomerNotFoundException("Customer does not exists");
        }
        return optionalCustomer.get();
    }

    public Customer updateCustomer (int customerId, Customer customer) {
       customer.setCustomerId(customerId);
       return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerId) {
       customerDAO.deleteById(customerId);
    }
}
