package com.melirate.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.melirate.auth.JwtValidator;
import com.melirate.dynamodb.DAOs.WeightDao;
import com.melirate.models.User;
import com.melirate.models.Weight;

import java.util.List;

public class GetAllWeightActivity implements RequestHandler<APIGatewayProxyRequestEvent, List<Weight>>{

    @Override
    public List<Weight> handleRequest(APIGatewayProxyRequestEvent request, Context context) {

        String token;
        String userId;

        try {
            token = request.getHeaders().get("Authorization");
        } catch (Exception e) {
            throw new IllegalArgumentException("Must include token.");
        }
        try {
            userId = request.getPath();
        } catch (Exception e) {
            throw new IllegalArgumentException("Must have user_id.");
        }

        User user = new User();
        user.setId(userId);

        JwtValidator jwtValidator = new JwtValidator();
        if (!jwtValidator.validateToken(token, user.getId())) {
            throw new RuntimeException("Invalid Token.");
        }

        WeightDao weightDao = new WeightDao();
        return weightDao.loadAllWeights(user.getId());
    }
}