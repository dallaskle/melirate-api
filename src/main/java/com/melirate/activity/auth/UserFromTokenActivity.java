package com.melirate.activity.auth;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.melirate.activity.auth.Requests.LoginRequest;
import com.melirate.activity.auth.Requests.UserFromTokenRequest;
import com.melirate.activity.auth.Responses.LoginResponse;
import com.melirate.auth.UserAuthService;
import com.melirate.dynamodb.DAOs.UserDao;
import com.melirate.dynamodb.models.User;

public class UserFromTokenActivity implements RequestHandler<UserFromTokenRequest, LoginResponse> {

    @Override
    public LoginResponse handleRequest(UserFromTokenRequest request, Context context) {
        // Extract email and password from request
        String token = request.getToken();

        UserAuthService userAuthService = new UserAuthService(new UserDao());

        // Call signupWithEmailAndPassword function with email and password
        User userResponse = userAuthService.getUserFromToken(token);

        LoginResponse loginResponse = new LoginResponse(userResponse, token);

        // Return the response
        return loginResponse;
    }
}
