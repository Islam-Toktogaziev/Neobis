package com.example.AvtoShop.Controller;


import com.example.AvtoShop.Entity.Employee;
import com.example.AvtoShop.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping ("/employees")
    public List<Employee> all(){
        return employeeService.getAllFromEmployees();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee one(@PathVariable Long employeeID) {
        return employeeService.getOneFromEmployees(employeeID);
    }


    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/employees/{employeeID}")
    public Employee employeeUpdate (@RequestBody Employee newEmployee, @PathVariable Long employeeID){
        return employeeService.employeeUpdate(newEmployee,employeeID);
    }

    @DeleteMapping("/employees/{employeeID}")
    public void deleteEmployee(@PathVariable Long employeeID) {
        employeeService.deleteEmployee(employeeID);
    }

}
