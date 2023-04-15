package com.melirate.dynamodb.DAOs;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.melirate.models.Weight;

import java.util.List;

public class WeightDao {

    public WeightDao() {
    }

    public Weight loadWeight(Weight _weight) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
        Weight weight = dynamoDBMapper.load(Weight.class, _weight.getUserId(), _weight.getTimestamp());
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
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
        dynamoDBMapper.save(weight);
        return weight;
    }
}
