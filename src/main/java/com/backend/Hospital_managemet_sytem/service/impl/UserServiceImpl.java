package com.backend.Hospital_managemet_sytem.service.impl;

import com.backend.Hospital_managemet_sytem.exceptions.ResourceNotFoundException;
import com.backend.Hospital_managemet_sytem.model.User;
import com.backend.Hospital_managemet_sytem.model.enumerations.UserRole;
import com.backend.Hospital_managemet_sytem.repository.UserRepository;
import com.backend.Hospital_managemet_sytem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createUser(User user) {
        log.debug("About to save user {}",user);
        // Encoding password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        log.debug("About to get user by ID {}",id);
        //check if user exists
        User user = userRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("User not found with ID "+ id));

        return user;
    }

    @Override
    public User updateUser(User user) {
        log.debug("About to get update user with ID {}",user.getId());
        //check if user exists
        User user1 = userRepository.findById(user.getId()).orElseThrow(()->
                new ResourceNotFoundException("User not found with ID "+ user.getId()));

        user1.setAddress(user.getAddress());
        user1.setEmail(user.getEmail());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setUsername(user.getUsername());

        log.debug("About to save user updated details {}",user1);

        return userRepository.save(user1);
    }

    @Override
    public List<User> getUsersByRole(UserRole userRole) {

        List<User> users = userRepository.findAllByRole(userRole);
        return users;
    }

    @Override
    public List<User> getUsers() {
        log.debug("Request to get all users");
        List<User> users = userRepository.findAll();
        return users;
    }



}
