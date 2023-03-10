package com.miltcn.sosti.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt.expiration}")
    private Long expirationTime;
    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String email) {
        return Jwts.builder().
                setSubject(email).
                setExpiration(new Date(System.currentTimeMillis() + expirationTime)).
                signWith(SignatureAlgorithm.HS512, secret.getBytes(StandardCharsets.UTF_8)).
                compact();
    }
}
