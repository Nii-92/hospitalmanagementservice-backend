package com.endodoo.hospitalmanagementservice_backend.service;

import com.endodoo.hospitalmanagementservice_backend.entity.User;
import com.endodoo.hospitalmanagementservice_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}