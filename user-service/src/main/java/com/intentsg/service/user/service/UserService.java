package com.intentsg.service.user.service;

import com.intentsg.service.user.model.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);
    List<User> getAllUsers();
}
