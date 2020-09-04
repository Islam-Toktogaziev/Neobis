package com.example.AvtoShop.Controller;


import com.example.AvtoShop.Entity.Customer;
import com.example.AvtoShop.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping ("/customers")
    public List<Customer> all(){
        return customerService.getAllFromCustomer();
    }

    @GetMapping("/customers/{customerID}")
    public Customer one(@PathVariable Long customerID) {
        return customerService.getOneFromCustomer(customerID);
    }


    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/customers/{customerID}")
    public Customer customerUpdate (@RequestBody Customer newCustomer, @PathVariable Long customerID){
        return customerService.customerUpdate(newCustomer,customerID);

    }

    @DeleteMapping("/customers/{customerID}")
    public void deleteCustomer(@PathVariable Long customerID) {
        customerService.deleteCustomer(customerID);
    }

}
