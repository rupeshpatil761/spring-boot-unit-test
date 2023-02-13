package com.rupesh.springboot.unittest.service;

import com.rupesh.springboot.unittest.exception.ResourceNotFoundException;
import com.rupesh.springboot.unittest.model.User;
import com.rupesh.springboot.unittest.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public User updateUser(Long id, User requestedUser) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        user.setName(requestedUser.getName());
        user.setEmail(requestedUser.getEmail());
        user.setUserType(requestedUser.getUserType());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        userRepository.delete(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
