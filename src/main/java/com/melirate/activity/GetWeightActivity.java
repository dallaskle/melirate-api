package com.melirate.activity;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.melirate.dynamodb.CompositeKeys.WeightPrimaryKey;
import com.melirate.models.Weight;

import java.util.List;





public class GetWeightActivity implements RequestHandler<WeightPrimaryKey, String>{

    @Override
    public String handleRequest(WeightPrimaryKey weightPrimaryKey, Context context) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
        Weight weight = dynamoDBMapper.load(Weight.class, weightPrimaryKey.getUserId(), weightPrimaryKey.getWeightId());
        return weight.toString();
    }
}
