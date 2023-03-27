package com.melirate.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.time.LocalDateTime;
import java.util.Date;

@DynamoDBTable(tableName = "Weights")
public class Weight {

    private String userId;
    private String weightId;
    private Double bodyWeight;
    private Double bodyFat;
    private Double muscle;
    private Double hydration;
    private String timestamp;

    public Weight() {
    }

    @DynamoDBHashKey(attributeName = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @DynamoDBRangeKey(attributeName = "weight_id")
    public String getWeightId() {
        return weightId;
    }

    public void setWeightId(String weightId) {
        this.weightId = weightId;
    }

    @DynamoDBAttribute(attributeName = "body_weight")
    public Double getBodyWeight() {
        return bodyWeight;
    }

    public void setBodyWeight(Double bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    @DynamoDBAttribute(attributeName = "body_fat")
    public Double getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(Double bodyFat) {
        this.bodyFat = bodyFat;
    }

    @DynamoDBAttribute(attributeName = "muscle")
    public Double getMuscle() {
        return muscle;
    }

    public void setMuscle(Double muscle) {
        this.muscle = muscle;
    }

    @DynamoDBAttribute(attributeName = "hydration")
    public Double getHydration() {
        return hydration;
    }

    public void setHydration(Double hydration) {
        this.hydration = hydration;
    }

    @DynamoDBAttribute(attributeName = "timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Weight)) {
            return false;
        }
        Weight other = (Weight) obj;
        return this.userId.equals(other.getUserId()) &&
                this.weightId.equals(other.getWeightId()) &&
                this.bodyWeight.equals(other.getBodyWeight()) &&
                this.bodyFat.equals(other.getBodyFat()) &&
                this.muscle.equals(other.getMuscle()) &&
                this.hydration.equals(other.getHydration()) &&
                this.timestamp.equals(other.getTimestamp());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.userId.hashCode();
        result = 31 * result + this.weightId.hashCode();
        result = 31 * result + this.bodyWeight.hashCode();
        result = 31 * result + this.bodyFat.hashCode();
        result = 31 * result + this.muscle.hashCode();
        result = 31 * result + this.hydration.hashCode();
        result = 31 * result + this.timestamp.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Weight{" +
                "userId='" + userId + '\'' +
                ", weightId='" + weightId + '\'' +
                ", bodyWeight=" + bodyWeight +
                ", bodyFat=" + bodyFat +
                ", muscle=" + muscle +
                ", hydration=" + hydration +
                ", timestamp=" + timestamp +
                '}';
    }
}
