package com.melirate.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.melirate.auth.JwtValidator;
import com.melirate.dynamodb.DAOs.WeightDao;
import com.melirate.models.Weight;

import java.util.Map;

public class GetWeightActivity implements RequestHandler<APIGatewayProxyRequestEvent, Weight>{

    @Override
    public Weight handleRequest(final APIGatewayProxyRequestEvent request, Context context) {

        context.getLogger().log("Handling request body " + request.getBody());
        context.getLogger().log("Handling request path " + request.getPath());
        // context.getLogger().log("Handling request pathParameters " + request.getPathParameters().toString());
        context.getLogger().log("Handling request headers " + request.getHeaders());
        context.getLogger().log("Handling request " + request);

        String token = request.getHeaders().get("Authorization");
        String userId = request.getPath();

        JwtValidator jwtValidator = new JwtValidator();
        if (!jwtValidator.validateToken(token, userId)) {
            throw new RuntimeException("Invalid Token: " + token + " for user id: " + userId);
        }

        Map<String, String> params =  request.getQueryStringParameters();
        String timestamp = params.get("timestamp");

        Weight weight = new Weight();
        weight.setUserId(userId);
        weight.setTimestamp(timestamp);

        WeightDao weightDao = new WeightDao();
        return weightDao.loadWeight(weight);
    }
}
