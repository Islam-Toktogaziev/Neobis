package com.example.AvtoShop.Controller;


import com.example.AvtoShop.CustomerRepository.CustomerRep;
import com.example.AvtoShop.Exceptions.CustomerNotFoundException;
import com.example.AvtoShop.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerRep customerRep;

    @Autowired
    public CustomerController(CustomerRep customerRep) {
        this.customerRep = customerRep;
    }

    @GetMapping ("/Customers")
    List<Customer> all(){
        return customerRep.findAll();
    }

    @GetMapping("/Customers/{id}")
    Customer one(@PathVariable Long id) {
        return customerRep.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }


    @PostMapping("/Customers")
    public ResponseEntity<?> create(@RequestBody Customer customer) {
        customerRep.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/Customers/{id}")
    public Customer customerUpdate (@RequestBody Customer newCustomer, @PathVariable Long id){
        return customerRep.findById(id)
                .map(customer -> {
                    customer.setCustomerName(newCustomer.getCustomerName());
                    customer.setReputationID(newCustomer.getReputationID());
                    customer.setAddress(newCustomer.getAddress());
                    customer.setEmail(newCustomer.getEmail());
                    customer.setNumber(newCustomer.getNumber());
                    return customerRep.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setCustomerID(id);
                    return customerRep.save(newCustomer);
                });
    }

    @DeleteMapping("/Customers/{id}")
    void deleteCustomer(@PathVariable Long id) {
        customerRep.deleteById(id);
    }

}
