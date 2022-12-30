package com.niit.authenticationservice.service;

import com.niit.authenticationservice.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtSecurityServiceGeneratorImpl implements SecurityServiceGenerator {

    @Override
    public Map<String, String> generateToken(User user) {
        String token = null;
        token = Jwts.builder().setSubject(user.getUserName())
                .setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "mySecret").compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("massage","User successfully logged in Server");
        return map;
    }
}
