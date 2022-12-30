package com.niit.authenticationservice.controller;

import com.niit.authenticationservice.domain.User;
import com.niit.authenticationservice.exception.UserNotFoundException;
import com.niit.authenticationservice.service.SecurityServiceGenerator;
import com.niit.authenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private ResponseEntity responseEntity;
    private UserService userService;
    private SecurityServiceGenerator securityServiceGenerator;

    @Autowired
    public UserController(UserService userService, SecurityServiceGenerator securityServiceGenerator) {
        this.userService = userService;
        this.securityServiceGenerator = securityServiceGenerator;
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user) throws UserNotFoundException {

        Map<String, String> map = null;
        try {
            User userObj = userService.findUserByUserIdAndUserPassword(user.getUserId(), user.getUserPassword());
            if (userObj.getUserId().equals(user.getUserId())) {
                map = securityServiceGenerator.generateToken(userObj);
            }
            responseEntity = new ResponseEntity(map, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        } catch (Exception exception) {
            responseEntity = new ResponseEntity("Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


    @PostMapping("/register")
    public ResponseEntity saveUser(@RequestBody User user) {

        User createdUser = userService.saveUser(user);
        return responseEntity = new ResponseEntity("User is Created" , HttpStatus.CREATED);
    }

    @GetMapping("/display")
    public ResponseEntity displayUser(){
        return new ResponseEntity<>(userService.displayAllUser(),HttpStatus.OK);
    }
}