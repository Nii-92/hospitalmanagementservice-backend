package com.endodoo.hospitalmanagementservice_backend.repository;

import com.endodoo.hospitalmanagementservice_backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}