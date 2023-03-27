package com.melirate.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.time.LocalDateTime;
import java.util.Objects;

@DynamoDBTable(tableName = "Measurements")
public class Measurement {

    private String measurementId;
    private String userId;
    private String timestamp;
    private double chest;
    private double shoulders;
    private double stomach;
    private double thighs;
    private double calves;
    private double arms;

    @DynamoDBHashKey(attributeName = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setMeasurementId(String measurementId) {
        this.measurementId = measurementId;
    }


    @DynamoDBRangeKey(attributeName="measurement_id")
    public String getMeasurementId() {
        return measurementId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @DynamoDBAttribute(attributeName = "timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @DynamoDBAttribute(attributeName = "chest")
    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    @DynamoDBAttribute(attributeName = "shoulders")
    public double getShoulders() {
        return shoulders;
    }

    public void setShoulders(double shoulders) {
        this.shoulders = shoulders;
    }

    @DynamoDBAttribute(attributeName = "stomach")
    public double getStomach() {
        return stomach;
    }

    public void setStomach(double stomach) {
        this.stomach = stomach;
    }

    @DynamoDBAttribute(attributeName = "thighs")
    public double getThighs() {
        return thighs;
    }

    public void setThighs(double thighs) {
        this.thighs = thighs;
    }

    @DynamoDBAttribute(attributeName = "calves")
    public double getCalves() {
        return calves;
    }

    public void setCalves(double calves) {
        this.calves = calves;
    }

    @DynamoDBAttribute(attributeName = "arms")
    public double getArms() {
        return arms;
    }

    public void setArms(double arms) {
        this.arms = arms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return getMeasurementId() == that.getMeasurementId() && Double.compare(that.getChest(), getChest()) == 0 && Double.compare(that.getShoulders(), getShoulders()) == 0 && Double.compare(that.getStomach(), getStomach()) == 0 && Double.compare(that.getThighs(), getThighs()) == 0 && Double.compare(that.getCalves(), getCalves()) == 0 && Double.compare(that.getArms(), getArms()) == 0 && Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getTimestamp(), that.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMeasurementId(), getUserId(), getTimestamp(), getChest(), getShoulders(), getStomach(), getThighs(), getCalves(), getArms());
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "measurementId=" + measurementId +
                ", userId=" + userId +
                ", timestamp=" + timestamp +
                ", chest=" + chest +
                ", shoulders=" + shoulders +
                ", stomach=" + stomach +
                ", thighs=" + thighs +
                ", calves=" + calves +
                ", arms=" + arms +
                '}';
    }
}
