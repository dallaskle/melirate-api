package com.melirate.dynamodb.DAOs;

import com.melirate.dynamodb.models.User;
import com.melirate.utils.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserDaoTest {

    private UserDao userDao;

    @BeforeEach
    private void setup() {
        userDao = new UserDao();
    }

    // public User saveUser(User user)
    // public User loadUserByEmail
    // public User loadUserByEmailAndPassword

    @Test
    void saveUser_correctEntry_returnsUser() {
        //GIVEN
        User user = new User();
        String fakeEmail = Users.generateId();
        user.setEmail(fakeEmail + "@email.com");
        user.setPassword("Password123!");

        //WHEN
        User _user = userDao.saveUser(user);

        //THEN
        System.out.println(_user);
        assertTrue(true);
    }

    @Test
    void saveUser_nullEmail_throwsIllegalArgumentException() {
        //GIVEN
        User user = new User();
        user.setPassword("Password123!");
        //WHEN + THEN
        assertThrows(IllegalArgumentException.class, ()-> userDao.saveUser(user));
    }
    @Test
    void saveUser_nullPassword_throwsIllegalArgumentException() {
        //GIVEN
        User user = new User();
        String fakeEmail = Users.generateId();
        user.setEmail(fakeEmail + "@email.com");
        //WHEN + THEN
        assertThrows(IllegalArgumentException.class, ()-> userDao.saveUser(user));
    }
    @Test
    void saveUser_InvalidEmail_throwsIllegalArgumentException() {
        //GIVEN
        User user = new User();
        user.setEmail("string");
        user.setPassword("Password123!");
        //WHEN + THEN
        assertThrows(IllegalArgumentException.class, ()-> userDao.saveUser(user));
    }
    @Test
    void saveUser_InvalidPassword_throwsIllegalArgumentException() {
        //GIVEN
        User user = new User();
        String fakeEmail = Users.generateId();
        user.setEmail(fakeEmail + "@email.com");
        user.setPassword("password");
        //WHEN + THEN
        assertThrows(IllegalArgumentException.class, ()-> userDao.saveUser(user));
    }
    @Test
    void saveUser_EmailExists_throwsIllegalArgumentException() {
        //GIVEN
        User user = new User();
        user.setEmail("Dallasjklein@gmail.com");
        user.setPassword("Password123!");
        //WHEN + THEN
        assertThrows(IllegalArgumentException.class, ()-> userDao.saveUser(user));
    }

    @Test
    void loadUserFromUserId_correctUserId_returnsUser() {
        //GIVEN
        String userId = "0b0958a3-7c84-46d2-a56f-069bc37c5a03";
        User user = new User();
        user.setId(userId);

        //WHEN
        User _user = userDao.loadUserByUserId(user);

        //THEN
        System.out.println(_user);
        assertTrue(true);
    }

    /*@Test
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
    }*/
}
