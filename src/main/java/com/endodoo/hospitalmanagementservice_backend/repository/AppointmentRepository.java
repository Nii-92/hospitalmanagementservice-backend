package com.endodoo.hospitalmanagementservice_backend.repository;

import com.endodoo.hospitalmanagementservice_backend.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}