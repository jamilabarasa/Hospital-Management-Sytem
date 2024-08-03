package com.backend.Hospital_managemet_sytem.controller;

import com.backend.Hospital_managemet_sytem.controller.vm.CreatedUserVM;
import com.backend.Hospital_managemet_sytem.controller.vm.JwtAuthResponse;
import com.backend.Hospital_managemet_sytem.controller.vm.SuccessReponseVM;
import com.backend.Hospital_managemet_sytem.dto.LoginDto;
import com.backend.Hospital_managemet_sytem.model.User;
import com.backend.Hospital_managemet_sytem.model.enumerations.Status;
import com.backend.Hospital_managemet_sytem.model.enumerations.UserRole;
import com.backend.Hospital_managemet_sytem.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<CreatedUserVM> createUser(@Valid @RequestBody User user){
        log.debug("REST Request to save user {}",user);
        User user1 = userService.createUser(user);
        SuccessReponseVM successReponse = new SuccessReponseVM(
                "User Created Successfully",
                String.valueOf(Status.SUCCESS),
                HttpStatus.CREATED.value(),
                System.currentTimeMillis()
        );

        CreatedUserVM createdUser = new CreatedUserVM(
                user1,
                successReponse
        );
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CreatedUserVM> updateUser(@Valid @RequestBody User user){
        log.debug("REST Request to update user with ID {}",user.getId());
        User user1 = userService.updateUser(user);
        SuccessReponseVM successReponse = new SuccessReponseVM(
                "User Updated Successfully",
                String.valueOf(Status.SUCCESS),
                HttpStatus.OK.value(),
                System.currentTimeMillis()
        );

        CreatedUserVM createdUser = new CreatedUserVM(
                user1,
                successReponse
        );
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        log.debug("REST Request to get all users");
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        log.debug("REST Request to get user by ID {}",id);
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @GetMapping("/role")
    public ResponseEntity<List<User>> getUserByRole(@RequestParam UserRole userRole){
        log.debug("REST Request to get users by role {}",userRole);
        List<User> users = userService.getUsersByRole(userRole);
        return new ResponseEntity<>(users,HttpStatus.OK);

    }



}
