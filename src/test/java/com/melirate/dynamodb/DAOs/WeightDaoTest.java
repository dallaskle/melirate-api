package com.melirate.dynamodb.DAOs;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.melirate.dynamodb.models.Weight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeightDaoTest {
    private AmazonDynamoDB client;
    private DynamoDBMapper dynamoDBMapper;
    private WeightDao weightDao;

    @BeforeEach
    private void setup() {
        client = AmazonDynamoDBClientBuilder.standard().build();
        dynamoDBMapper = new DynamoDBMapper(client);
        weightDao = new WeightDao();
    }

    @Test
    void saveWeight_correctEntry_returnsTrue() {
        //GIVEN
        Weight weight = new Weight();
        weight.setBodyWeight(76.0);
        weight.setBodyFat(.234);
        weight.setMuscle(37.2);
        weight.setHydration(.57);
        weight.setTimestamp("2023-03-25");

        //WHEN

        //THEN
    }
}
