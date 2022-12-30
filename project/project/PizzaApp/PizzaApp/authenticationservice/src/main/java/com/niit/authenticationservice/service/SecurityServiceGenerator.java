package com.niit.authenticationservice.service;

import com.niit.authenticationservice.domain.User;

import java.util.Map;

public interface SecurityServiceGenerator {
Map<String,String> generateToken(User user);
}
