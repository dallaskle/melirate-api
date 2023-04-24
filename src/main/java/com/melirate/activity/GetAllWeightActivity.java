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

        context.getLogger().log("Handling request body " + request.getBody());
        context.getLogger().log("Handling request path " + request.getPath());
       // context.getLogger().log("Handling request pathParameters " + request.getPathParameters().toString());
        context.getLogger().log("Handling request headers " + request.getHeaders());
        context.getLogger().log("Handling request " + request);

        String id = request.getPath();
        String token = request.getHeaders().get("Authorization");

        User user = new User();
        user.setId(id);

        JwtValidator jwtValidator = new JwtValidator();
        if (!jwtValidator.validateToken(token, user.getId())) {
            throw new RuntimeException("Invalid Token: " + token + " for user id: " + user.getId());
        }

        WeightDao weightDao = new WeightDao();
        return weightDao.loadAllWeights(user.getId());
    }
}