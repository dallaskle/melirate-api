package com.melirate.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.melirate.dynamodb.CompositeKeys.WeightPrimaryKey;
import com.melirate.models.Weight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Accesses data for a weight using {@link Weight} to represent the model in DynamoDB.
 */
public class WeightDao {
    private final DynamoDBMapper dynamoDbMapper;

    /**
     * Instantiates a WeightDao object.
     *
     * @param dynamoDbMapper the {@link DynamoDBMapper} used to interact with the playlists table
     */
    public WeightDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    public Weight saveWeight(Weight weight) {
        this.dynamoDbMapper.save(weight);
        return weight;
    }

    public Weight getWeight(String user_id, String weight_id) {
        WeightPrimaryKey weightPrimaryKey = new WeightPrimaryKey();
        weightPrimaryKey.setUserId(user_id);
        weightPrimaryKey.setWeightId(weight_id);

        Weight weight = dynamoDbMapper.load(Weight.class, weightPrimaryKey);

        return weight;
    }

}

