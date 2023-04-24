package com.melirate.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.Key;

public class JwtValidator {
    private SecretHolder secretHolder = new SecretHolder("jwt.secret"); ;

    public JwtValidator() {

    }

    public boolean validateToken(String jwtToken, String userId) {

        if (jwtToken == null) {
            throw new NullPointerException("Must include token.");
        }
        if (userId == null) {
            throw new NullPointerException("Must have user_id!");
        }

        Key key = Keys.hmacShaKeyFor(secretHolder.getSecret().getBytes(StandardCharsets.UTF_8));

        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwtToken);

            String subject = claimsJws.getBody().getSubject();
            return subject.equals(userId);
        } catch (Exception e) {
            // token is invalid or expired
            return false;
        }
    }
}
