package com.example.EmployeeService.repository;

import com.example.EmployeeService.model.Employee;
import com.example.EmployeeService.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface HealthCareRepository extends CrudRepository<Patient,Long> {

}
