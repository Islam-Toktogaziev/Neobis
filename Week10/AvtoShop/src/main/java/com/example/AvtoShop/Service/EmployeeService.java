package com.example.AvtoShop.Service;

import com.example.AvtoShop.Entity.Employee;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllFromEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getOneFromEmployees(Long employeeID) {
        return employeeRepository.findById(employeeID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find employee with ID ", employeeID));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee employeeUpdate (Employee newEmployee, Long employeeID){
        return employeeRepository.findById(employeeID)
                .map(employee -> {
                    employee.setEmployeeName(newEmployee.getEmployeeName());
                    employee.setPositionID(newEmployee.getPositionID());
                    employee.setAddress(newEmployee.getAddress());
                    employee.setEmail(newEmployee.getEmail());
                    employee.setNumber(newEmployee.getNumber());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find employee wit ID ", employeeID));

    }

    public void deleteEmployee(Long employeeID) {
        employeeRepository.deleteById(employeeID);
    }


}
