package com.melirate;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import static com.amazonaws.regions.Regions.US_WEST_2;

public class Main {

    private AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
    private DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
    public void testerMethod() {

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}