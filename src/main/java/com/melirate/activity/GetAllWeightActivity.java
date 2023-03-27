package com.melirate.activity;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.melirate.dynamodb.CompositeKeys.WeightPrimaryKey;
import com.melirate.dynamodb.Requests.AllWeightRequest;
import com.melirate.models.Weight;

import java.util.List;

public class GetAllWeightActivity implements RequestHandler<AllWeightRequest, List<Weight>>{



    @Override
    public List<Weight> handleRequest(AllWeightRequest request, Context context) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
        Weight weight = new Weight();
        weight.setUserId(request.getUserId());
        DynamoDBQueryExpression<Weight> queryExpression = new DynamoDBQueryExpression<Weight>()
                .withHashKeyValues(weight);
        List<Weight> weights = dynamoDBMapper.query(Weight.class, queryExpression);

        return weights;
    }
}