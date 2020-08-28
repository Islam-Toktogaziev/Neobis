package com.example.AvtoShop.Service;

import com.example.AvtoShop.Entity.Contracts;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.ContractRepository;
import com.example.AvtoShop.Repository.CustomerRepository;
import com.example.AvtoShop.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    private final ContractRepository contractRepository;

    private final CustomerRepository customerRepository;

    private final EmployeeRepository employeeRepository;

    @Autowired
    private ContractService (ContractRepository contractRepository,
                                CustomerRepository customerRepository,
                                EmployeeRepository employeeRepository){
        this.contractRepository = contractRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Contracts> getAllFromContracts(){
        return contractRepository.findAll();
    }

    public Contracts getOneFromContracts(Long contractID){
        return contractRepository.findById(contractID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find contract with ID ", contractID));
    }

    public List<Contracts> getAllByCustomerIDFromContracts (Long customerID){
        return contractRepository.findByCustomerID(customerRepository.findById(customerID));
    }

    public Contracts getOneByCustomerIDFromContracts (Long customerID, Long contractID){
        if (!customerRepository.existsById(customerID)){
            throw new ResourceNotFoundException("Could not find customer with ID ",customerID);
        }
        return contractRepository.findByContractIDAndCustomerID(contractID, customerRepository.findById(customerID));
    }

    public List<Contracts> getAllByEmployeeIDFromContracts (Long employeeID){
        return contractRepository.findByEmployeeID(employeeRepository.findById(employeeID));
    }

    public Contracts getOneByEmployeeIDFromContracts (Long employeeID, Long contractID){
        if (!employeeRepository.existsById(employeeID)){
            throw new ResourceNotFoundException("Could not find employee with ID ",employeeID);
        }
        return contractRepository.findByContractIDAndEmployeeID(contractID,employeeRepository.findById(employeeID));
    }

    public Contracts createContractByCustomerID (Long customerID, Contracts contracts) {
        return customerRepository.findById(customerID).map(customer -> {
            contracts.setCustomerID(customer);
            return contractRepository.save(contracts);
        }).orElseThrow(() -> new ResourceNotFoundException("Could not find customer with ID ",customerID));
    }
}
