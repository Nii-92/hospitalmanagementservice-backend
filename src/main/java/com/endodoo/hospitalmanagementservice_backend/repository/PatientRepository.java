package com.endodoo.hospitalmanagementservice_backend.repository;

import com.endodoo.hospitalmanagementservice_backend.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}