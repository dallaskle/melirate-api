package com.melirate.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;

public class JwtGenerator {

    SecretHolder secretHolder;

    public JwtGenerator() {
    }

    public String generateToken(String userId) {
        secretHolder = new SecretHolder("jwt.secret");
        Key key = Keys.hmacShaKeyFor(secretHolder.getSecret().getBytes(StandardCharsets.UTF_8));
        return Jwts.builder().setSubject(userId).signWith(key).compact();
    }
}
