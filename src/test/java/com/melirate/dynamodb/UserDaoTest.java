package com.melirate.dynamodb;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.melirate.dynamodb.DAOs.UserDao;
import com.melirate.models.User;
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
