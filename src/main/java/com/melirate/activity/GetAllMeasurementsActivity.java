package com.melirate.activity;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.melirate.dynamodb.Requests.AllWeightRequest;
import com.melirate.models.Measurement;
import com.melirate.models.Weight;

import java.util.List;

public class GetAllMeasurementsActivity implements RequestHandler<AllWeightRequest, List<Measurement>>{



    @Override
    public List<Measurement> handleRequest(AllWeightRequest request, Context context) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
        Measurement measurement = new Measurement();
        measurement.setUserId(request.getUserId());
        DynamoDBQueryExpression<Measurement> queryExpression = new DynamoDBQueryExpression<Measurement>()
                .withHashKeyValues(measurement);
        List<Measurement> measurements = dynamoDBMapper.query(Measurement.class, queryExpression);

        return measurements;
    }
}