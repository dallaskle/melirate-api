package com.melirate.activity;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.melirate.dynamodb.CompositeKeys.MeasurementPrimaryKey;
import com.melirate.models.Measurement;

public class GetMeasurementActivity implements RequestHandler<MeasurementPrimaryKey, String>{

    @Override
    public String handleRequest(MeasurementPrimaryKey measurementPrimaryKey, Context context) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
        Measurement measurement = dynamoDBMapper.load(Measurement.class, measurementPrimaryKey.getUserId(), measurementPrimaryKey.getMeasurementId());
        return measurement.toString();
    }
}