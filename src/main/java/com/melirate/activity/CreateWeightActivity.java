package com.melirate.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.melirate.activity.Requests.CreateWeightRequest;
import com.melirate.auth.JwtValidator;
import com.melirate.dynamodb.DAOs.WeightDao;
import com.melirate.dynamodb.models.Weight;

public class CreateWeightActivity implements RequestHandler<CreateWeightRequest, Weight>{

    @Override
    public Weight handleRequest(CreateWeightRequest request, Context context) {

        String token = request.getToken();
        String userId = request.getUserId();

        JwtValidator jwtValidator = new JwtValidator();
        if (!jwtValidator.validateToken(token, userId)) {
            throw new RuntimeException("Invalid Token.");
        }

        Weight weight = new Weight();
        weight.setUserId(userId);
        weight.setTimestamp(request.getTimestamp());
        try {
            weight.setBodyWeight(Double.valueOf(request.getBodyWeight()));
            weight.setBodyFat(Double.valueOf(request.getBodyFat()));
            weight.setMuscle(Double.valueOf(request.getMuscle()));
            weight.setHydration(Double.valueOf(request.getHydration()));
        } catch(NumberFormatException e) {
            throw new NumberFormatException("Input values are formatted incorrectly.");
        }

        WeightDao weightDao = new WeightDao();
        weightDao.saveWeight(weight);
        return weight;
    }
}
