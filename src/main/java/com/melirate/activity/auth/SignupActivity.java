package com.melirate.activity.auth;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.melirate.activity.auth.Requests.SignupRequest;
import com.melirate.activity.auth.Responses.LoginResponse;
import com.melirate.auth.UserAuthService;
import com.melirate.dynamodb.DAOs.UserDao;

public class SignupActivity implements RequestHandler<SignupRequest, LoginResponse> {

    @Override
    public LoginResponse handleRequest(SignupRequest request, Context context) {
        // Extract email and password from request
        String email = request.getEmail();
        String password = request.getPassword();

        UserAuthService userAuthService = new UserAuthService(new UserDao());

        // Call signupWithEmailAndPassword function with email and password
        LoginResponse response = userAuthService.signupWithEmailAndPassword(email, password);

        // Return the response
        return response;
    }
}
