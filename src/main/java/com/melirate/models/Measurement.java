package com.melirate.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.Objects;

@DynamoDBTable(tableName = "melirate-measurements")
public class Measurement {

    private String userId;
    private String timestamp;
    private Double arms;
    private Double calves;
    private Double chest;
    private Double shoulders;
    private Double stomach;
    private Double thighs;

    public Measurement() {
    }

    @DynamoDBHashKey(attributeName = "user_id")
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @DynamoDBRangeKey(attributeName = "timestamp")
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @DynamoDBAttribute(attributeName = "arms")
    public Double getArms() {
        return arms;
    }
    public void setArms(Double arms) {
        this.arms = arms;
    }

    @DynamoDBAttribute(attributeName = "calves")
    public Double getCalves() {
        return calves;
    }
    public void setCalves(Double calves) {
        this.calves = calves;
    }

    @DynamoDBAttribute(attributeName = "chest")
    public Double getChest() {
        return chest;
    }
    public void setChest(Double chest) {
        this.chest = chest;
    }

    @DynamoDBAttribute(attributeName = "shoulders")
    public Double getShoulders() {
        return shoulders;
    }
    public void setShoulders(Double shoulders) {
        this.shoulders = shoulders;
    }

    @DynamoDBAttribute(attributeName = "stomach")
    public Double getStomach() {
        return stomach;
    }
    public void setStomach(Double stomach) {
        this.stomach = stomach;
    }

    @DynamoDBAttribute(attributeName = "thighs")
    public Double getThighs() {
        return thighs;
    }
    public void setThighs(Double thighs) {
        this.thighs = thighs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getTimestamp(), that.getTimestamp()) && Objects.equals(getArms(), that.getArms()) && Objects.equals(getCalves(), that.getCalves()) && Objects.equals(getChest(), that.getChest()) && Objects.equals(getShoulders(), that.getShoulders()) && Objects.equals(getStomach(), that.getStomach()) && Objects.equals(getThighs(), that.getThighs());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getTimestamp(), getArms(), getCalves(), getChest(), getShoulders(), getStomach(), getThighs());
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "userId='" + userId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", arms=" + arms +
                ", calves=" + calves +
                ", chest=" + chest +
                ", shoulders=" + shoulders +
                ", stomach=" + stomach +
                ", thighs=" + thighs +
                '}';
    }
}
