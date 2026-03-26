package com.endodoo.hospitalmanagementservice_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class HealthInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String providerName;
    private String policyNumber;
    private String coverageType;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;   // <-- add this field
}