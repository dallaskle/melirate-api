package com.melirate.activity.auth.Requests;

public class UserFromTokenRequest {

    private String token;

    public UserFromTokenRequest() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
