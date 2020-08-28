package com.example.AvtoShop.Controller;

import com.example.AvtoShop.Entity.Contracts;
import com.example.AvtoShop.Service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping ("/contracts")
    public List<Contracts> all(){
        return contractService.getAllFromContracts();
    }

    @GetMapping ("/contracts/{contractID}")
    public Contracts one(@PathVariable Long contractID){
        return contractService.getOneFromContracts(contractID);
    }

    @GetMapping ("/customers/{customerID}/contracts")
    public List<Contracts> getAllByCustomerID (@PathVariable(value = "customerID") Long customerID){
        return contractService.getAllByCustomerIDFromContracts(customerID);
    }

    @GetMapping ("/customers/{customerID}/contracts/{contractID}")
    public Contracts oneByCustomerID(@PathVariable (value = "customerID") Long customerID,
                      @PathVariable (value = "contractID") Long contractID){
        return contractService.getOneByCustomerIDFromContracts(customerID,contractID);
    }

    @GetMapping ("/employees/{employeeID}/contracts")
    public List<Contracts> getAllByEmployeeID (@PathVariable(value = "employeeID") Long employeeID){
        return contractService.getAllByEmployeeIDFromContracts(employeeID);
    }

    @GetMapping ("/employees/{employeeID}/contracts/{contractID}")
    public Contracts oneByEmployeeID(@PathVariable (value = "employeeID") Long employeeID,
                      @PathVariable (value = "contractID") Long contractID){
        return contractService.getOneByEmployeeIDFromContracts(employeeID,contractID);
    }

    @PostMapping("/customers/{customerID}/contracts")
    public Contracts createContract (@PathVariable (value = "customerID") Long customerID,
                               @RequestBody Contracts contracts) {
        return contractService.createContractByCustomerID(customerID,contracts);
    }
}
