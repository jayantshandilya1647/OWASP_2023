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
    public Patient getSpecificPatientDetails(@PathVariable("id") Long id,
                                            @RequestHeader("Authorization")String token) {
        Optional<Patient> patientOptional = healthCareService.fetchPatientDetails(id);
        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            if (token != null && token.equalsIgnoreCase("doctor")) {
                return patient; // Doctor can access all details
            } else if (token != null && token.equalsIgnoreCase("nurse")) {
                // Nurse can access limited details
                Patient limitedPatient = new Patient();
                limitedPatient.setId(patient.getId());
                limitedPatient.setName(patient.getName());
                limitedPatient.setPrescription(patient.getPrescription());
                return limitedPatient;
            } else {
                throw new RuntimeException("User is NOT authorized !");
            }
        } else {
            throw new RuntimeException("Patient not found !");
        }
    }

    @DeleteMapping ("/api/v2/patients/{id}")
    public void removePatientAuth(@PathVariable("id")Long id,
                                  @RequestHeader("Authorization")String token){
        if(token !=null && token.equalsIgnoreCase("doctor"))
            healthCareService.removePatientDetails(id);
        else
            throw new RuntimeException("User is NOT authorized !");
    }
}
