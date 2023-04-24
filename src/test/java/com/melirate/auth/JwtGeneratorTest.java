package com.melirate.auth;

import com.melirate.auth.JwtGenerator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.sql.SQLOutput;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JwtGeneratorTest {

    JwtGenerator jwtGenerator;
    SecretHolder secretHolder;

    @BeforeEach
    private void setup() throws IOException {
        this.jwtGenerator = new JwtGenerator();
        this.secretHolder = new SecretHolder("jwt.secret");
    }

    @Test
    void generateToken_validId_returnsToken() {
        //GIVEN
        String userId = "1";
        Key key = Keys.hmacShaKeyFor(secretHolder.getSecret().getBytes(StandardCharsets.UTF_8));

        //WHEN
        String token = jwtGenerator.generateToken(userId);
        //eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIn0.t0ZyfZEl0txIo_nKRwUtNJyzb4kRPNjL7rh9hdmBQBQ

        //THEN
        System.out.println(token);
        assertNotNull(token);
        assertTrue(Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject().equals("1"));
    }
}
