package com.melirate.activity;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.melirate.dynamodb.DAOs.WeightDao;
import com.melirate.models.Weight;

public class CreateWeightActivity implements RequestHandler<Weight, Weight>{

    @Override
    public Weight handleRequest(Weight weight, Context context) {
        WeightDao weightDao = new WeightDao();
        try {
            weightDao.saveWeight(weight);
        } catch (Exception e) {
            System.out.println("Exception!");
            return new Weight();
        }
        return weight;
    }
}
