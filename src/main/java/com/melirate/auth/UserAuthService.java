package com.melirate.auth;

import com.melirate.auth.Responses.LoginResponse;
import com.melirate.dynamodb.DAOs.UserDao;
import com.melirate.models.User;
import com.melirate.utils.Users;

public class UserAuthService {

    UserDao userDao;

    public UserAuthService(UserDao userDao) {
        this.userDao = userDao;
    }

    public LoginResponse loginWithEmailPassword(String email, String password) {

        if (email == null) { //Needs to have an email
            throw new IllegalArgumentException("Must have email!");
        }
        if (password == null) { //Needs to have a password --> can remove if there's forget password option, or email to sign in
            throw new IllegalArgumentException("Must have password!");
        }

        User user = new User();
        user.setEmail(email);

        String token;

        try {
            user = userDao.loadUserByEmail(user);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Can't login. Incorrect email and/or password.");
        }

        if (!PasswordHasher.checkPassword(password, user.getPassword())) {
            throw new IllegalArgumentException("Can't login. Incorrect email and/or password.");
        }

        JwtGenerator jwtGenerator = new JwtGenerator();
        token = jwtGenerator.generateToken(user.getId());

        return new LoginResponse(user, token);
    }


    public LoginResponse signupWithEmailAndPassword(String email, String password) {

        //require valid email
        //require valid password

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        String token;

        try {
            user = userDao.saveUser(user);;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Can't signup. " + e.getLocalizedMessage());
        }

        JwtGenerator jwtGenerator = new JwtGenerator();
        token = jwtGenerator.generateToken(user.getId());

        return new LoginResponse(user, token);

    }



}
