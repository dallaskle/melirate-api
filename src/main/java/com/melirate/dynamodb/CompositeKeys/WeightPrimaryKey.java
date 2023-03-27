package com.melirate.dynamodb.CompositeKeys;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

@DynamoDBDocument
public class WeightPrimaryKey {
    private String userId;
    private String weightId;

    @DynamoDBHashKey(attributeName = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @DynamoDBRangeKey(attributeName = "weight_id")
    public String getWeightId() {
        return weightId;
    }

    public void setWeightId(String weightId) {
        this.weightId = weightId;
    }
}