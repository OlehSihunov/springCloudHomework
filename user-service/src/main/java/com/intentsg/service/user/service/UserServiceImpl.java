package com.intentsg.service.user.service;

import com.intentsg.service.user.model.User;
import com.intentsg.service.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    public UserServiceImpl() {
    }
    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
