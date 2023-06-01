package com.melirate.activity.weights;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.melirate.activity.weights.Requests.DeleteWeightRequest;
import com.melirate.auth.JwtValidator;
import com.melirate.dynamodb.DAOs.WeightDao;
import com.melirate.dynamodb.models.Weight;

public class DeleteWeightActivity implements RequestHandler<DeleteWeightRequest, Weight>{

    @Override
    public Weight handleRequest(DeleteWeightRequest request, Context context) {

        String token = request.getToken();
        String userId = request.getUserId();

        JwtValidator jwtValidator = new JwtValidator();
        if (!jwtValidator.validateToken(token, userId)) {
            throw new RuntimeException("403: Invalid Token.");
        }

        Weight weight = new Weight();
        weight.setUserId(userId);
        weight.setTimestamp(request.getTimestamp());

        WeightDao weightDao = new WeightDao();
        weightDao.deleteWeight(weight);
        return weight;
    }
}
