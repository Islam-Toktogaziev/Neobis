package com.example.AvtoShop.Controller;


import com.example.AvtoShop.Entity.Employee;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping ("/employees")
    List<Employee> all(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee one(@PathVariable Long employeeID) {
        return employeeRepository.findById(employeeID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find employee ", employeeID));
    }


    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/employees/{employeeID}")
    public Employee employeeUpdate (@RequestBody Employee newEmployee, @PathVariable Long employeeID){
        return employeeRepository.findById(employeeID)
                .map(employee -> {
                    employee.setEmployeeName(newEmployee.getEmployeeName());
                    employee.setPositionID(newEmployee.getPositionID());
                    employee.setAddress(newEmployee.getAddress());
                    employee.setEmail(newEmployee.getEmail());
                    employee.setNumber(newEmployee.getNumber());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find employee ", employeeID));

    }

    @DeleteMapping("/employees/{employeeID}")
    void deleteEmployee(@PathVariable Long employeeID) {
        employeeRepository.deleteById(employeeID);
    }

}
