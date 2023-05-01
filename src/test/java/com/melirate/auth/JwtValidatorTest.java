package com.melirate.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JwtValidatorTest {

    JwtValidator jwtValidator;
    JwtGenerator jwtGenerator;

    @BeforeEach
    public void setup() {
        this.jwtValidator = new JwtValidator();
        this.jwtGenerator = new JwtGenerator();
    }

    @Test
    public void validateToken_validTokenAndUserId_returnsTrue() {
        // GIVEN
        String userId = "1";
        String token = jwtGenerator.generateToken(userId);

        // WHEN
        boolean valid = jwtValidator.validateToken(token, userId);

        // THEN
        assertTrue(valid, "Token isn't validated");
    }

    @Test
    public void validateToken_validTokenAndInvalidUserId_returnsFalse() {
        // GIVEN
        String userId = "1";
        String invalidUserId = "0";
        String token = jwtGenerator.generateToken(userId);

        // WHEN
        boolean valid = jwtValidator.validateToken(token, invalidUserId);

        // THEN
        assertFalse(valid, "Token is validated");
    }

    @Test
    public void validateToken_invalidToken_returnsFalse() {
        // GIVEN
        String userId = "1";
        String token = jwtGenerator.generateToken(userId);

        // WHEN
        boolean valid = jwtValidator.validateToken("sjkdfakd43093qfj2403f", userId);

        // THEN
        assertFalse(valid, "Token is validated");
    }

}
