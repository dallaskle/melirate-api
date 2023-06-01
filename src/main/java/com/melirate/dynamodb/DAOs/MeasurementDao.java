package com.melirate.dynamodb.DAOs;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.melirate.dynamodb.models.Measurement;
import com.melirate.dynamodb.models.Weight;
import com.melirate.utils.Users;

import java.util.List;

public class MeasurementDao {

    public MeasurementDao() {
    }

    public Measurement loadMeasurement(Measurement _measurement) {

        if (_measurement.getUserId() == null ) {
            throw new NullPointerException("400-06: Must have user_id!");
        }
        if (_measurement.getTimestamp() == null ) {
            throw new NullPointerException("400-07: Must include timestamp.");
        }

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
        Measurement measurement = dynamoDBMapper.load(Measurement.class, _measurement.getUserId(), _measurement.getTimestamp());
        if (measurement == null) {
            throw new NullPointerException("400-08: Can't find this measurement entry.");
        }
        return measurement;
    }

    public List<Measurement> loadAllMeasurements(String userId) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
        Measurement measurement = new Measurement();
        measurement.setUserId(userId);
        DynamoDBQueryExpression<Measurement> queryExpression = new DynamoDBQueryExpression<Measurement>()
                .withHashKeyValues(measurement);
        List<Measurement> measurements = dynamoDBMapper.query(Measurement.class, queryExpression);
        return measurements;
    }

    public Measurement saveMeasurement(Measurement measurement) {

        if (measurement.getUserId() == null ) {
            throw new NullPointerException("400-06: Must have user_id!");
        }
        if (measurement.getTimestamp() == null ) {
            measurement.setTimestamp(Users.generateTimestamp());
        }

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
        dynamoDBMapper.save(measurement);
        return measurement;
    }

    public Measurement deleteMeasurement(Measurement measurement) {

        if (measurement.getUserId() == null ) {
            throw new NullPointerException("400-06: Must have user_id!");
        }
        if (measurement.getTimestamp() == null ) {
            throw new NullPointerException("400-10: Must have timestamp");
        }

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
        dynamoDBMapper.delete(measurement);
        return measurement;
    }

}
