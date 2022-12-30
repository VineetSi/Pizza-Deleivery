package com.niit.authenticationservice.service;

import com.niit.authenticationservice.domain.User;
import com.niit.authenticationservice.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> displayAllUser();
    public User findUserByUserIdAndUserPassword(String userId,String userPassword) throws UserNotFoundException;
}
