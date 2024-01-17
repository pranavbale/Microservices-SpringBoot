package com.pranavbale.user.service.Service.impl;

import com.pranavbale.user.service.Entity.User;
import com.pranavbale.user.service.Repository.UserRepository;
import com.pranavbale.user.service.Service.UserService;
import com.pranavbale.user.service.exception.ResourceNotFountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(UUID userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFountException("User is not found on the server " + userId));
    }

    @Override
    public String deleteUser(UUID userId) {
        User user = getUser(userId);
        userRepository.delete(user);
        return "User deleted successfully " + userId;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
