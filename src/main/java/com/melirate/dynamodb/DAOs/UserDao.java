package com.melirate.dynamodb.DAOs;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.melirate.auth.PasswordHasher;
import com.melirate.dynamodb.models.User;
import com.melirate.utils.Users;

import java.util.*;

public class UserDao {

    DynamoDBMapper dynamoDBMapper;

    public UserDao() {

    }

    public User loadUserByIdAndTimestamp(User _user) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
        User user = dynamoDBMapper.load(User.class, _user.getId(), _user.getTimestamp());
        return user;
    }

    public User loadUserByEmailAndPassword(User _user) {

        if (_user.getEmail() == null) { //Needs to have an email
            throw new IllegalArgumentException("Must have email!");
        }
        if (_user.getPassword() == null) { //Needs to have a password --> can remove if there's forget password option, or email to sign in
            throw new IllegalArgumentException("Must have password!");
        }

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);

        AttributeValue emailAttributeValue = new AttributeValue().withS(_user.getEmail());
        AttributeValue passwordAttributeValue = new AttributeValue().withS(_user.getPassword());

        DynamoDBQueryExpression<User> queryExpression = new DynamoDBQueryExpression<User>()
                .withIndexName("email-index")
                .withConsistentRead(false)
                .withKeyConditionExpression("#email = :emailVal")
                .withFilterExpression("password = :passwordVal")
                .withExpressionAttributeNames(Map.of("#email", "email"))
                .withExpressionAttributeValues(Map.of(
                        ":emailVal", emailAttributeValue,
                        ":passwordVal", passwordAttributeValue
                ));


        List<User> existingUsers = dynamoDBMapper.query(User.class, queryExpression);

        if (!existingUsers.isEmpty()) {
            // a user with matching email and password was found
            return existingUsers.get(0);
        } else {
            // no user with matching email and password was found
            throw new IllegalArgumentException("No account found with this email and password combination.");
        }
    }

    public User loadUserByEmail(User _user) {

        if (_user.getEmail() == null) { //Needs to have an email
            throw new IllegalArgumentException("Must have email!");
        }

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);

        AttributeValue emailAttributeValue = new AttributeValue().withS(_user.getEmail());

        DynamoDBQueryExpression<User> queryExpression = new DynamoDBQueryExpression<User>()
                .withIndexName("email-index")
                .withConsistentRead(false)
                .withKeyConditionExpression("#email = :emailVal")
                .withExpressionAttributeNames(Map.of("#email", "email"))
                .withExpressionAttributeValues(Map.of(
                        ":emailVal", emailAttributeValue
                ));


        List<User> existingUsers = dynamoDBMapper.query(User.class, queryExpression);

        if (!existingUsers.isEmpty()) {
            // a user with matching email and password was found
            return existingUsers.get(0);
        } else {
            // no user with matching email and password was found
            throw new IllegalArgumentException("No account found with this email.");
        }
    }

    public User saveUser(User user) {

        if (user.getEmail() == null) { //Needs to have an email
            throw new IllegalArgumentException("Must have email!");
        }
        if (user.getPassword() == null) { //Needs to have a password --> can remove if there's forget password option, or email to sign in
            throw new IllegalArgumentException("Must have password!");
        }
        if (user.getId() == null) { //Needs to have an id
            user.setId(Users.generateId());
        }
        if (user.getTimestamp() == null) { //Needs to have an id
            user.setTimestamp(Users.generateTimestamp());
        }

        if (!Users.isValidEmail(user.getEmail())) {
            throw new IllegalArgumentException("Must have a valid email.");
        }
        if (!Users.hasPasswordRequirements(user.getPassword())) {
            throw new IllegalArgumentException("Must have a password with at least 8 characters, an uppercase letter, a lowercase letter, a digit, and a special character.");
        }
        user.setPassword(PasswordHasher.hashPassword(user.getPassword()));

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);

        boolean run = true;

        while (run) {
            //does user email or id exist
            AttributeValue emailAttributeValue = new AttributeValue().withS(user.getEmail());
            AttributeValue idAttributeValue = new AttributeValue().withS(user.getId());
            DynamoDBQueryExpression<User> queryExpression = new DynamoDBQueryExpression<User>()
                    .withIndexName("email-index")
                    .withConsistentRead(false)
                    .withKeyConditionExpression("#id = :id OR #email = :email")
                    .withExpressionAttributeValues(
                            new HashMap<String, AttributeValue>() {{
                                put(":id", idAttributeValue);
                                put(":email", emailAttributeValue);
                            }})
                    .withExpressionAttributeNames(
                            new HashMap<String, String>() {{
                                put("#id", "id");
                                put("#email", "email");
                            }});
            List<User> existingUsers = dynamoDBMapper.query(User.class, queryExpression);

            if (!existingUsers.isEmpty()) {

                for (User thisUser : existingUsers) {
                    if (thisUser.getEmail().equals(user.getEmail())) {
                        throw new IllegalArgumentException("Email already exists.");
                    } else if (thisUser.getId().equals(user.getId())) {
                        user.setId(Users.generateId());
                    }
                }
            } else {
                run = false;
            }
        }

        dynamoDBMapper.save(user);
        return user;
    }
}

