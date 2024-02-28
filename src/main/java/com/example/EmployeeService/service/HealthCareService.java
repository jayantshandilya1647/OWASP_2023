package com.example.EmployeeService.service;

import com.example.EmployeeService.model.Patient;
import com.example.EmployeeService.repository.HealthCareRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HealthCareService {

    private final HealthCareRepository healthCareRepository;

    public HealthCareService(HealthCareRepository healthCareRepository){
        this.healthCareRepository = healthCareRepository;
    }

    public Optional<Patient> fetchPatientDetails(Long id){
        return healthCareRepository.findById(id);
    }

    public void removePatientDetails(Long id){
        healthCareRepository.deleteById(id);
    }

}
