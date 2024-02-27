package com.example.EmployeeService.controller;

import com.example.EmployeeService.model.Patient;
import com.example.EmployeeService.service.HealthCareService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HealthCareController {
    private HealthCareService healthCareService;

    public HealthCareController(HealthCareService healthCareService){
        this.healthCareService = healthCareService;
    }

    @GetMapping("/api/patients/patient_id/{id}")
    public Optional<Patient> getPatientDetails(@PathVariable("id")Long id){
        return healthCareService.fetchPatientDetails(id);
    }

    @GetMapping("/api/health/patients/patient_id/{id}")
    public Optional<Patient> getSpecificPatientDetails(@PathVariable("id") Long id,
                                                     @RequestHeader("Authorization")String token)
    {
        if(token !=null && token.equalsIgnoreCase("doctor"))
            return healthCareService.fetchPatientDetails(id);
        else
            throw new RuntimeException("User is NOT authorized !");
    }
}
