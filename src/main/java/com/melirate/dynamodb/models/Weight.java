package com.melirate.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "melirate-weights")
public class Weight {

    private String userId;
    private String timestamp;
    private Double bodyWeight;
    private Double bodyFat;
    private Double muscle;
    private Double hydration;

    public Weight() {
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
                ", bodyWeight=" + bodyWeight +
                ", bodyFat=" + bodyFat +
                ", muscle=" + muscle +
                ", hydration=" + hydration +
                ", timestamp=" + timestamp +
                '}';
    }

}
