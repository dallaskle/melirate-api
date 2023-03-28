package com.melirate.activity;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.melirate.dynamodb.CompositeKeys.ImagePrimaryKey;
import com.melirate.models.Image;

import java.util.List;





public class GetImageActivity implements RequestHandler<ImagePrimaryKey, String>{

    @Override
    public String handleRequest(ImagePrimaryKey imagePrimaryKey, Context context) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
        Image image = dynamoDBMapper.load(Image.class, imagePrimaryKey.getUserId(), imagePrimaryKey.getImageId());
        return image.getImageUrl();
    }
}