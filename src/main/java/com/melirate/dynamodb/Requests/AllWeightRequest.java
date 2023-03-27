package com.melirate.dynamodb.Requests;

public class AllWeightRequest {
    private String userId;

    public AllWeightRequest() {

    }

    public AllWeightRequest(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
