package com.melirate.activity.measurements;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.melirate.activity.measurements.Requests.CreateMeasurementRequest;
import com.melirate.auth.JwtValidator;
import com.melirate.dynamodb.DAOs.MeasurementDao;
import com.melirate.dynamodb.models.Measurement;

public class CreateMeasurementActivity implements RequestHandler<CreateMeasurementRequest, Measurement> {

    @Override
    public Measurement handleRequest(CreateMeasurementRequest request, Context context) {

        String token = request.getToken();
        String userId = request.getUserId();

        JwtValidator jwtValidator = new JwtValidator();
        if (!jwtValidator.validateToken(token, userId)) {
            throw new RuntimeException("403: Invalid Token.");
        }

        Measurement measurement = new Measurement();
        measurement.setUserId(userId);
        measurement.setTimestamp(request.getTimestamp());
        try {
            measurement.setChest(request.getChest());
            measurement.setShoulders(request.getShoulders());
            measurement.setStomach(request.getStomach());
            measurement.setBack(request.getBack());
            measurement.setThighs(request.getThighs());
            measurement.setCalves(request.getCalves());
            measurement.setArms(request.getArms());

        } catch (NumberFormatException e) {
            throw new NumberFormatException("400-09: Input values are formatted incorrectly.");
        }

        MeasurementDao measurementDao = new MeasurementDao();
        measurementDao.saveMeasurement(measurement);
        return measurement;
    }
}
