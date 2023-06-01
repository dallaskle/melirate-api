package com.melirate.activity.measurements.Requests;

public class CreateMeasurementRequest {

    private String userId;
    private String timestamp;
    private Double chest;
    private Double shoulders;
    private Double stomach;
    private Double back;
    private Double thighs;
    private Double calves;
    private Double arms;
    private String token;

    public CreateMeasurementRequest() {
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

    public Double getChest() {
        return chest;
    }

    public void setChest(Double chest) {
        this.chest = chest;
    }

    public Double getShoulders() {
        return shoulders;
    }

    public void setShoulders(Double shoulders) {
        this.shoulders = shoulders;
    }

    public Double getStomach() {
        return stomach;
    }

    public void setStomach(Double stomach) {
        this.stomach = stomach;
    }

    public Double getBack() {
        return back;
    }

    public void setBack(Double back) {
        this.back = back;
    }

    public Double getThighs() {
        return thighs;
    }

    public void setThighs(Double thighs) {
        this.thighs = thighs;
    }

    public Double getCalves() {
        return calves;
    }

    public void setCalves(Double calves) {
        this.calves = calves;
    }

    public Double getArms() {
        return arms;
    }

    public void setArms(Double arms) {
        this.arms = arms;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "CreateMeasurementRequest{" +
                "userId='" + userId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", chest='" + chest + '\'' +
                ", shoulders='" + shoulders + '\'' +
                ", stomach='" + stomach + '\'' +
                ", back='" + back + '\'' +
                ", thighs='" + thighs + '\'' +
                ", calves='" + calves + '\'' +
                ", arms='" + arms + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}

