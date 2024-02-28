package com.example.EmployeeService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NursePatientVisibility {
    @Id
    private Long id;
    private String name;
    private String prescription;
    private String diagnosis;
}
