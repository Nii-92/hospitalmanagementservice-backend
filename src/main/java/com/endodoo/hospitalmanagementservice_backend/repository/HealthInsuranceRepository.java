package com.endodoo.hospitalmanagementservice_backend.repository;

import com.endodoo.hospitalmanagementservice_backend.entity.HealthInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthInsuranceRepository extends JpaRepository<HealthInsurance, Long> {
}