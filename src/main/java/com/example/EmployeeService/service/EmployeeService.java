package com.example.EmployeeService.service;

import com.example.EmployeeService.Entity.Employee;
import com.example.EmployeeService.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Optional<Employee> getEmployee(Long id)
    {
        return repository.findById(id);

    }

    public List<Employee> getEmployeeDetails() {
        return (List<Employee>) repository.findAll();
    }

    public void deleteEmployee(Long id) {
         repository.deleteById(id);
    }

    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }
}
