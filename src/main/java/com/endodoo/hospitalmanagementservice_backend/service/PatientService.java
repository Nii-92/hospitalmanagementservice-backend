package com.endodoo.hospitalmanagementservice_backend.service;

import com.endodoo.hospitalmanagementservice_backend.entity.Patient;
import com.endodoo.hospitalmanagementservice_backend.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Save a new patient
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Get patient by ID
    public Patient getPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElse(null); // or throw exception if preferred
    }

    // Update patient
    public Patient updatePatient(Long id, Patient patientDetails) {
        Patient existingPatient = getPatientById(id);
        if (existingPatient != null) {
            existingPatient.setName(patientDetails.getName());
            existingPatient.setEmail(patientDetails.getEmail());
            existingPatient.setPhone(patientDetails.getPhone());
            existingPatient.setAddress(patientDetails.getAddress());
            // Add any other fields your assignment requires
            return patientRepository.save(existingPatient);
        }
        return null; // or throw exception if not found
    }

    // Delete patient
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}