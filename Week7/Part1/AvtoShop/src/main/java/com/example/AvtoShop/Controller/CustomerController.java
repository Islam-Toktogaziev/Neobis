package com.example.AvtoShop.Controller;


import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.CustomerRepository;
import com.example.AvtoShop.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping ("/customers")
    List<Customer> all(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer one(@PathVariable Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }


    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/customers/{id}")
    public Customer customerUpdate (@RequestBody Customer newCustomer, @PathVariable Long id){
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setCustomerName(newCustomer.getCustomerName());
                    customer.setReputationID(newCustomer.getReputationID());
                    customer.setAddress(newCustomer.getAddress());
                    customer.setEmail(newCustomer.getEmail());
                    customer.setNumber(newCustomer.getNumber());
                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));

    }

    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }

}
