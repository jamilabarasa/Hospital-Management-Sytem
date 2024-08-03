package com.backend.Hospital_managemet_sytem.service;

import com.backend.Hospital_managemet_sytem.dto.LoginDto;
import com.backend.Hospital_managemet_sytem.model.User;
import com.backend.Hospital_managemet_sytem.model.enumerations.UserRole;

import java.util.List;

public interface UserService {
    //create user
    //update user
    //get user by id
    //get users by role
    //get all users

    User createUser(User user);

    User getUserById(Long id);

    User updateUser(User user);

    List<User> getUsersByRole(UserRole userRole);

    List<User> getUsers();



}
