package com.melirate.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.melirate.dynamodb.DAOs.WeightDao;
import com.melirate.dynamodb.CompositeKeys.WeightPrimaryKey;


public class GetWeightActivity implements RequestHandler<WeightPrimaryKey, String>{

    @Override
    public String handleRequest(WeightPrimaryKey weightPrimaryKey, Context context) {
        WeightDao weightDao = new WeightDao()
    }
}
