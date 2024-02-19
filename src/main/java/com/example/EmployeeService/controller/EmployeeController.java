package com.example.EmployeeService.controller;

import com.example.EmployeeService.Entity.Employee;
import com.example.EmployeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;
    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeDetailsById(@PathVariable("id") Long id)
    {
      return service.getEmployee(id);
    }

    @GetMapping("/employee/details/{id}")
    public Optional<Employee> getEmployeeDetailsById(@PathVariable("id") Long id,
                                                     @RequestHeader("Authorization") String token)
    {
        if(token != null && token.equals("humanresource")) {
            return service.getEmployee(id);
        }else{
            throw new RuntimeException("User not authorized for all data set \n");
        }
    }

    @PostMapping("/employee")
    public Employee getEmployeeDetailsById(@RequestBody Employee employee)
    {
        return service.createEmployee(employee);
    }
    @DeleteMapping("/employee/{id}")
    public void deleteEmployeeDetailsById(@PathVariable("id") Long id)
    {
         service.deleteEmployee(id);
    }
    @GetMapping("/employee")
    public List<Employee> findALlEmployeeDetails()
    {
        return service.getEmployeeDetails();
    }
}
