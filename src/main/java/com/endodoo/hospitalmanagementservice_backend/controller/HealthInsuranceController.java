package com.endodoo.hospitalmanagementservice_backend.controller;

import com.endodoo.hospitalmanagementservice_backend.entity.HealthInsurance;
import com.endodoo.hospitalmanagementservice_backend.repository.HealthInsuranceRepository;
import com.endodoo.hospitalmanagementservice_backend.entity.Patient;
import com.endodoo.hospitalmanagementservice_backend.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/health-insurance")
public class HealthInsuranceController {

    @Autowired
    private HealthInsuranceRepository healthInsuranceRepository;

    @Autowired
    private PatientRepository patientRepository;

    // GET all health insurances
    @GetMapping
    public List<HealthInsurance> getAllHealthInsurances() {
        return healthInsuranceRepository.findAll();
    }

    // GET health insurance by ID
    @GetMapping("/{id}")
    public ResponseEntity<HealthInsurance> getHealthInsuranceById(@PathVariable Long id) {
        Optional<HealthInsurance> insurance = healthInsuranceRepository.findById(id);
        return insurance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST new health insurance for a patient
    @PostMapping
    public ResponseEntity<HealthInsurance> createHealthInsurance(
            @RequestParam Long patientId,
            @RequestBody HealthInsurance insurance) {

        Optional<Patient> patientOpt = patientRepository.findById(patientId);
        if (patientOpt.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        insurance.setPatient(patientOpt.get());
        HealthInsurance saved = healthInsuranceRepository.save(insurance);
        return ResponseEntity.ok(saved);
    }

    // PUT update health insurance
    @PutMapping("/{id}")
    public ResponseEntity<HealthInsurance> updateHealthInsurance(
            @PathVariable Long id,
            @RequestBody HealthInsurance insuranceDetails) {

        Optional<HealthInsurance> insuranceOpt = healthInsuranceRepository.findById(id);
        if (insuranceOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        HealthInsurance insurance = insuranceOpt.get();
        insurance.setProviderName(insuranceDetails.getProviderName());
        insurance.setPolicyNumber(insuranceDetails.getPolicyNumber());
        insurance.setCoverageType(insuranceDetails.getCoverageType());

        HealthInsurance updated = healthInsuranceRepository.save(insurance);
        return ResponseEntity.ok(updated);
    }

    // DELETE health insurance
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHealthInsurance(@PathVariable Long id) {
        if (!healthInsuranceRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        healthInsuranceRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}