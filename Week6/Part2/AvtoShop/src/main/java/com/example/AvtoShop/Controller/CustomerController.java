package com.example.AvtoShop.Controller;


import com.example.AvtoShop.CustomerRepository.CustomerRep;
import com.example.AvtoShop.Exceptions.CustomerNotFoundException;
import com.example.AvtoShop.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerRep customerRep;

    @Autowired
    public CustomerController(CustomerRep customerRep) {
        this.customerRep = customerRep;
    }

    @GetMapping ("/customers")
    List<Customer> all(){
        return customerRep.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer one(@PathVariable Long id) {
        return customerRep.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }


    @PostMapping("/customers")
    public Customer newCustomer(@RequestBody Customer customer) {
        return customerRep.save(customer);
    }

    @PutMapping("/customers/{id}")
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

    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable Long id) {
        customerRep.deleteById(id);
    }

}
