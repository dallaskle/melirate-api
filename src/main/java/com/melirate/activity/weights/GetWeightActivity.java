package com.melirate.activity.weights;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.melirate.auth.JwtValidator;
import com.melirate.dynamodb.DAOs.WeightDao;
import com.melirate.dynamodb.models.Weight;

import java.util.Map;

public class GetWeightActivity implements RequestHandler<APIGatewayProxyRequestEvent, Weight>{

    @Override
    public Weight handleRequest(final APIGatewayProxyRequestEvent request, Context context) {

        String token;
        String userId;

        try {
            token = request.getHeaders().get("Authorization");
        } catch (Exception e) {
            throw new IllegalArgumentException("401: Must include token.");
        }
        try {
            userId = request.getPath();
        } catch (Exception e) {
            throw new IllegalArgumentException("400-06: Must have user_id.");
        }


        JwtValidator jwtValidator = new JwtValidator();
        if (!jwtValidator.validateToken(token, userId)) {
            throw new RuntimeException("403: Invalid Token.");
        }

        Map<String, String> params;
        String timestamp;

        try {
            params =  request.getQueryStringParameters();
            timestamp = params.get("timestamp");
        } catch (Exception e) {
            throw new NullPointerException("400-07: Must include timestamp.");
        }

        Weight weight = new Weight();
        weight.setUserId(userId);
        weight.setTimestamp(timestamp);

        WeightDao weightDao = new WeightDao();
        return weightDao.loadWeight(weight);
    }
}
