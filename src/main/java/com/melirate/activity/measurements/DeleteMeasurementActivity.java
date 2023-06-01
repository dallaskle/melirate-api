package com.melirate.activity.measurements;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.melirate.activity.measurements.Requests.DeleteMeasurementRequest;
import com.melirate.auth.JwtValidator;
import com.melirate.dynamodb.DAOs.MeasurementDao;
import com.melirate.dynamodb.models.Measurement;

public class DeleteMeasurementActivity implements RequestHandler<DeleteMeasurementRequest, Measurement>{

    @Override
    public Measurement handleRequest(DeleteMeasurementRequest request, Context context) {

        String token = request.getToken();
        String userId = request.getUserId();

        JwtValidator jwtValidator = new JwtValidator();
        if (!jwtValidator.validateToken(token, userId)) {
            throw new RuntimeException("403: Invalid Token.");
        }

        Measurement measurement = new Measurement();
        measurement.setUserId(userId);
        measurement.setTimestamp(request.getTimestamp());

        MeasurementDao measurementDao = new MeasurementDao();
        measurementDao.deleteMeasurement(measurement);
        return measurement;
    }
}
