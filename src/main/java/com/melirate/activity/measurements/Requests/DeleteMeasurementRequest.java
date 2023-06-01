package com.melirate.activity.measurements.Requests;

public class DeleteMeasurementRequest {

    private String userId;
    private String timestamp;
    private String token;

    public DeleteMeasurementRequest() {
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "DeleteMeasurementRequest{" +
                "userId='" + userId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
