package com.melirate.activity.measurements;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.melirate.auth.JwtValidator;
import com.melirate.dynamodb.DAOs.MeasurementDao;
import com.melirate.dynamodb.DAOs.WeightDao;
import com.melirate.dynamodb.models.Measurement;
import com.melirate.dynamodb.models.User;
import com.melirate.dynamodb.models.Weight;

import java.util.List;

public class GetAllMeasurementActivity implements RequestHandler<APIGatewayProxyRequestEvent, List<Measurement>>{

    @Override
    public List<Measurement> handleRequest(APIGatewayProxyRequestEvent request, Context context) {

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

        User user = new User();
        user.setId(userId);

        JwtValidator jwtValidator = new JwtValidator();
        if (!jwtValidator.validateToken(token, user.getId())) {
            throw new RuntimeException("403: Invalid Token.");
        }

        MeasurementDao measurementDao = new MeasurementDao();
        return measurementDao.loadAllMeasurements(user.getId());
    }
}