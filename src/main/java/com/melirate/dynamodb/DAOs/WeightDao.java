package com.melirate.dynamodb.DAOs;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.melirate.dynamodb.models.Weight;
import com.melirate.utils.Users;

import java.util.List;

public class WeightDao {

    public WeightDao() {
    }

    public Weight loadWeight(Weight _weight) {

        if (_weight.getUserId() == null ) {
            throw new NullPointerException("400-06: Must have user_id!");
        }
        if (_weight.getTimestamp() == null ) {
            throw new NullPointerException("400-07: Must include timestamp.");
        }

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
        Weight weight = dynamoDBMapper.load(Weight.class, _weight.getUserId(), _weight.getTimestamp());
        if (weight == null) {
            throw new NullPointerException("400-08: Can't find this weight entry.");
        }
        return weight;
    }

    public List<Weight> loadAllWeights(String userId) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
        Weight weight = new Weight();
        weight.setUserId(userId);
        DynamoDBQueryExpression<Weight> queryExpression = new DynamoDBQueryExpression<Weight>()
                .withHashKeyValues(weight);
        List<Weight> weights = dynamoDBMapper.query(Weight.class, queryExpression);
        return weights;
    }

    public Weight saveWeight(Weight weight) {

        if (weight.getUserId() == null ) {
            throw new NullPointerException("400-06: Must have user_id!");
        }
        if (weight.getTimestamp() == null ) {
            weight.setTimestamp(Users.generateTimestamp());
        }

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
        dynamoDBMapper.save(weight);
        return weight;
    }

    public Weight deleteWeight(Weight weight) {

        if (weight.getUserId() == null ) {
            throw new NullPointerException("400-06: Must have user_id!");
        }
        if (weight.getTimestamp() == null ) {
            throw new NullPointerException("400-10: Must have timestamp");
        }

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
        dynamoDBMapper.delete(weight);
        return weight;
    }
}
