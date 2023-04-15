package com.melirate.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.melirate.dynamodb.DAOs.WeightDao;
import com.melirate.models.User;
import com.melirate.models.Weight;

import java.util.List;

public class GetAllWeightActivity implements RequestHandler<User, List<Weight>>{

    @Override
    public List<Weight> handleRequest(User user, Context context) {
        WeightDao weightDao = new WeightDao();
        return weightDao.loadAllWeights(user.getId());
    }
}