package com.example.AvtoShop.Service;

import com.example.AvtoShop.Entity.Customer;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllFromCustomer(){
        return customerRepository.findAll();
    }

    public Customer getOneFromCustomer(Long customerID) {
        return customerRepository.findById(customerID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find customer ", customerID));
    }


    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer customerUpdate (Customer newCustomer, Long customerID){
        return customerRepository.findById(customerID)
                .map(customer -> {
                    customer.setCustomerName(newCustomer.getCustomerName());
                    customer.setReputationID(newCustomer.getReputationID());
                    customer.setAddress(newCustomer.getAddress());
                    customer.setEmail(newCustomer.getEmail());
                    customer.setNumber(newCustomer.getNumber());
                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find customer ", customerID));

    }

    public void deleteCustomer(Long customerID) {
        customerRepository.deleteById(customerID);
    }

}
