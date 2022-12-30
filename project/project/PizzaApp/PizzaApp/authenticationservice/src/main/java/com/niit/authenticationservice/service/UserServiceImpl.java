package com.niit.authenticationservice.service;

import com.niit.authenticationservice.domain.User;
import com.niit.authenticationservice.exception.UserNotFoundException;
import com.niit.authenticationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> displayAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByUserIdAndUserPassword(String userId, String userPassword) throws UserNotFoundException {
        User user=userRepository.findByUserIdAndUserPassword(userId,userPassword );
        if(user==null){
            throw new UserNotFoundException();
        }
        return user;
    }
}
