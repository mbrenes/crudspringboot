package com.firstapp.crudspringboot.api;

import com.firstapp.crudspringboot.model.Customer;
import com.firstapp.crudspringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomerList() {
        return customerService.getCustomerList();
    }

    @GetMapping(value="/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        return customerService.getCustomer(customerId);
    }

    @PutMapping(value="/{customerId}")
    public Customer updateCustomer (@PathVariable int customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId, customer);
    }
    @DeleteMapping(value="/{customerId}")
    public void deleteCustomer (@PathVariable int customerId){
        customerService.deleteCustomer(customerId);
    }


}

