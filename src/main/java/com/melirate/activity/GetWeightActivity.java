package com.melirate.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.melirate.dynamodb.DAOs.WeightDao;
import com.melirate.dynamodb.CompositeKeys.WeightPrimaryKey;
import com.melirate.models.Weight;


public class GetWeightActivity implements RequestHandler<Weight, Weight>{

    @Override
    public Weight handleRequest(final Weight weight, Context context) {
        WeightDao weightDao = new WeightDao();
        return weightDao.loadWeight(weight);
    }
}
