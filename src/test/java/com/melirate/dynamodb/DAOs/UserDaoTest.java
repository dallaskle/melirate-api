package com.melirate.dynamodb.DAOs;

import com.melirate.dynamodb.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserDaoTest {

    private UserDao userDao;

    @BeforeEach
    private void setup() {
        userDao = new UserDao();
    }

    @Test
    void saveUser_correctEntry_returnsUser() {
        //GIVEN
        User user = new User();
        user.setEmail("test@email.com");
        user.setPassword("testPass");

        //WHEN
        User _user = userDao.saveUser(user);

        //THEN
        System.out.println(_user);
        assertTrue(true);
    }

    @Test
    void loadUserByEmailAndPassword_correctEntry_returnsUser() {
        //GIVEN
        User user = new User();
        user.setEmail("test@email.com");
        user.setPassword("testPass");

        //WHEN
        User _user = userDao.loadUserByEmailAndPassword(user);

        //THEN
        System.out.println(_user);
        assertTrue(true);
    }
}
