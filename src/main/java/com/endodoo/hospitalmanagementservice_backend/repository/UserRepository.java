package com.endodoo.hospitalmanagementservice_backend.repository;

import com.endodoo.hospitalmanagementservice_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}