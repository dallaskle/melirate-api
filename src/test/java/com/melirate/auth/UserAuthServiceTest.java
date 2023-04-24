package com.melirate.auth;

import com.melirate.activity.auth.Responses.LoginResponse;
import com.melirate.dynamodb.DAOs.UserDao;
import com.melirate.dynamodb.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserAuthServiceTest {

    UserAuthService userAuthService;
    JwtValidator jwtValidator;

    @BeforeEach
    public void setup() {
        jwtValidator = new JwtValidator();
        userAuthService = new UserAuthService(new UserDao());
    }

    @Test
    public void loginWithEmailPassword_valid_returnLoginResponse() {
        // GIVEN
        String email = "test2@email.com";
        String password = "testPass";

        // WHEN
        LoginResponse loginResponse = userAuthService.loginWithEmailPassword(email, password);

        // THEN
        System.out.println(loginResponse.getUser().toString());
        System.out.println(loginResponse.getToken().toString());
        assertNotNull(loginResponse.getUser());
        assertNotNull(loginResponse.getToken());
    }

    @Test
    public void loginWithEmailPassword_InvalidEmail_throwsIllegalArgumentException() {
        // GIVEN
        String email = "invalid_email@email.com";
        String password = "testPass";

        // WHEN
        // THEN
        assertThrows(IllegalArgumentException.class, ()-> {
            LoginResponse loginResponse = userAuthService.loginWithEmailPassword(email, password);
        }, "Should throw an illegal argument exception");
    }

    @Test
    public void loginWithEmailPassword_InvalidPassword_throwsIllegalArgumentException() {
        // GIVEN
        String email = "test@email.com";
        String password = "invalidPassword";

        // WHEN
        // THEN
        assertThrows(IllegalArgumentException.class, ()-> {
            LoginResponse loginResponse = userAuthService.loginWithEmailPassword(email, password);
        }, "Should throw an illegal argument exception");
    }

    @Test
    public void signupWithEmailPassword_valid_returnLoginResponse() {
        // GIVEN
        String email = "test2@email.com";
        String password = "testPass";

        // WHEN
        LoginResponse loginResponse = userAuthService.signupWithEmailAndPassword(email, password);
        String token = loginResponse.getToken();
        User user = loginResponse.getUser();

        // THEN
        System.out.println(user.toString());
        System.out.println(token.toString());
        assertNotNull(user);
        assertNotNull(token);
        assertTrue(jwtValidator.validateToken(token, user.getId()));
    }
}
