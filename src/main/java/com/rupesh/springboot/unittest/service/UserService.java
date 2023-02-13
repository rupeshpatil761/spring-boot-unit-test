package com.rupesh.springboot.unittest.service;

import com.rupesh.springboot.unittest.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User addUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(Long id, User book);

    void deleteUser(Long id);

    void deleteUser(User user);
}
