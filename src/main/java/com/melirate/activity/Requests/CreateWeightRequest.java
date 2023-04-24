package com.melirate.activity.Requests;

public class CreateWeightRequest {

    private String userId;
    private String timestamp;
    private String bodyWeight;
    private String bodyFat;
    private String muscle;
    private String hydration;
    private String token;

    public CreateWeightRequest() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBodyWeight() {
        return bodyWeight;
    }

    public void setBodyWeight(String bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public String getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(String bodyFat) {
        this.bodyFat = bodyFat;
    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public String getHydration() {
        return hydration;
    }

    public void setHydration(String hydration) {
        this.hydration = hydration;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "CreateWeightRequest{" +
                "userId='" + userId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", bodyWeight=" + bodyWeight +
                ", bodyFat=" + bodyFat +
                ", muscle=" + muscle +
                ", hydration=" + hydration +
                ", token='" + token + '\'' +
                '}';
    }
}
