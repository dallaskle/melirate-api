package com.melirate.activity;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.melirate.models.Measurement;
import com.melirate.models.Weight;

public class CreateMeasurementActivity implements RequestHandler<Measurement, String>{

    @Override
    public String handleRequest(Measurement measurement, Context context) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
        dynamoDBMapper.save(measurement);
        return measurement.toString();
    }
}
