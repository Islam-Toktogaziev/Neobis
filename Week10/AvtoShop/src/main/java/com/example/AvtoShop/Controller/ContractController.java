package com.example.AvtoShop.Controller;

import com.example.AvtoShop.Entity.Contracts;
import com.example.AvtoShop.Entity.Employee;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.ContractRepository;
import com.example.AvtoShop.Repository.CustomerRepository;
import com.example.AvtoShop.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContractController {

    private final ContractRepository contractRepository;

    private final CustomerRepository customerRepository;

    private final EmployeeRepository employeeRepository;

    @Autowired
    private ContractController (ContractRepository contractRepository,
                                CustomerRepository customerRepository,
                                EmployeeRepository employeeRepository){
        this.contractRepository = contractRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping ("/contracts")
    public List<Contracts> all(){
        return contractRepository.findAll();
    }

    @GetMapping ("/contracts/{contractID}")
    public Contracts one(@PathVariable Long contractID){
        return contractRepository.findById(contractID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find contract with id ", contractID));
    }

    @GetMapping ("/customers/{customerID}/contracts")
    public List<Contracts> getAllByCustomerID (@PathVariable(value = "customerID") Long customerID){
        return contractRepository.findByCustomerID(customerRepository.findById(customerID));
    }

    @GetMapping ("/customers/{customerID}/contracts/{contractID}")
    public Contracts oneByCustomerID(@PathVariable (value = "customerID") Long customerID,
                      @PathVariable (value = "contractID") Long contractID){
        if (!customerRepository.existsById(customerID)){
            throw new ResourceNotFoundException("Could not find customer ",customerID);
        }
        return contractRepository.findByContractIDAndCustomerID(contractID, customerRepository.findById(customerID));
    }

    @GetMapping ("/employees/{employeeID}/contracts")
    public List<Contracts> getAllByEmployeeID (@PathVariable(value = "employeeID") Long employeeID){
        return contractRepository.findByEmployeeID(employeeRepository.findById(employeeID));
    }

    @GetMapping ("/employees/{employeeID}/contracts/{contractID}")
    public Contracts oneByEmployeeID(@PathVariable (value = "employeeID") Long employeeID,
                      @PathVariable (value = "contractID") Long contractID){
        if (!employeeRepository.existsById(employeeID)){
            throw new ResourceNotFoundException("Could not find customer ",employeeID);
        }
        return contractRepository.findByContractIDAndEmployeeID(contractID,employeeRepository.findById(employeeID));
    }

    @PostMapping("/customers/{customerID}/contracts")
    public Contracts createOrder (@PathVariable (value = "customerID") Long customerID,
                               @RequestBody Contracts contracts) {
        return customerRepository.findById(customerID).map(customer -> {
            contracts.setCustomerID(customer);
            return contractRepository.save(contracts);
        }).orElseThrow(() -> new ResourceNotFoundException("Could not find customer ",customerID));
    }
}
