package com.example.EmployeeService.controller;

import com.example.EmployeeService.model.Patient;
import com.example.EmployeeService.service.HealthCareService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HealthCareController {
    private HealthCareService healthCareService;

    public HealthCareController(HealthCareService healthCareService){
        this.healthCareService = healthCareService;
    }

    @GetMapping("/api/v1/patients/{id}")
    public Optional<Patient> getPatientDetails(@PathVariable("id")Long id){
        return healthCareService.fetchPatientDetails(id);
    }

    @DeleteMapping ("/api/v1/patients/{id}")
    public void removePatient(@PathVariable("id")Long id){
        healthCareService.removePatientDetails(id);
    }

    @GetMapping("/api/v2/patients/{id}")
    public Optional<Patient> getSpecificPatientDetails(@PathVariable("id") Long id,
                                                     @RequestHeader("Authorization")String token)
    {
        if(token !=null && token.equalsIgnoreCase("doctor"))
            return healthCareService.fetchPatientDetails(id);
        else
            throw new RuntimeException("User is NOT authorized !");
    }
}
