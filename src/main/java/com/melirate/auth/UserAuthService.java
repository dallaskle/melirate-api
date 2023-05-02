package com.melirate.auth;

import com.melirate.activity.auth.Responses.LoginResponse;
import com.melirate.dynamodb.DAOs.UserDao;
import com.melirate.dynamodb.models.User;

public class UserAuthService {

    UserDao userDao;

    public UserAuthService(UserDao userDao) {
        this.userDao = userDao;
    }

    public LoginResponse loginWithEmailPassword(String email, String password) {

        if (email == null) { //Needs to have an email
            throw new IllegalArgumentException("400-01: Must have email!");
        }
        if (password == null) { //Needs to have a password --> can remove if there's forget password option, or email to sign in
            throw new IllegalArgumentException("400-02: Must have password!");
        }

        User user = new User();
        user.setEmail(email.toLowerCase());

        String token;

        try {
            user = userDao.loadUserByEmail(user);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("400-03a: Can't login. Incorrect email and/or password.");
        }

        if (!PasswordHasher.checkPassword(password, user.getPassword())) {
            throw new IllegalArgumentException("400-03b: Can't login. Incorrect email and/or password.");
        }

        JwtGenerator jwtGenerator = new JwtGenerator();
        token = jwtGenerator.generateToken(user.getId());

        return new LoginResponse(user, token);
    }

    public LoginResponse signupWithEmailAndPassword(String email, String password) {

        //require valid email
        //require valid password
        if (email == null) { //Needs to have an email
            throw new IllegalArgumentException("400-01: Must have email!");
        }
        if (password == null) { //Needs to have a password --> can remove if there's forget password option, or email to sign in
            throw new IllegalArgumentException("400-02: Must have password!");
        }

        User user = new User();
        user.setEmail(email.toLowerCase());
        user.setPassword(password);

        String token;

        user = userDao.saveUser(user);

        JwtGenerator jwtGenerator = new JwtGenerator();
        token = jwtGenerator.generateToken(user.getId());

        return new LoginResponse(user, token);

    }

    public User getUserFromToken(String jwtToken) {

        User user = new User();

        JwtValidator jwtValidator = new JwtValidator();
        String userId = jwtValidator.pullUserIdFromToken(jwtToken);
        user.setId(userId);

        return userDao.loadUserByUserId(user);
    }

}
