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

    @GetMapping("/employees/{id}")
    public Employee one(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }


    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee employeeUpdate (@RequestBody Employee newEmployee, @PathVariable Long id){
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setEmployeeName(newEmployee.getEmployeeName());
                    employee.setPositionID(newEmployee.getPositionID());
                    employee.setAddress(newEmployee.getAddress());
                    employee.setEmail(newEmployee.getEmail());
                    employee.setNumber(newEmployee.getNumber());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));

    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }

}
