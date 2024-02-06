package com.example.EmployeeService.repository;

import com.example.EmployeeService.Entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

}
