package com.melirate.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.Objects;

@DynamoDBTable(tableName = "melirate-images")
public class Image {

    private String userId;
    private String timestamp;
    private String imageUrl;
    private String view;

    public Image() {

    }

    @DynamoDBHashKey(attributeName = "user_id")
    public String getUserId() {
        return userId;
    }

    @DynamoDBRangeKey(attributeName = "timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @DynamoDBAttribute(attributeName = "imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @DynamoDBAttribute(attributeName = "view")
    public String getView() {
        return view;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setView(String view) {
        this.view = view;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(getUserId(), image.getUserId()) && Objects.equals(getTimestamp(), image.getTimestamp()) && Objects.equals(getImageUrl(), image.getImageUrl()) && Objects.equals(getView(), image.getView());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getTimestamp(), getImageUrl(), getView());
    }

    @Override
    public String toString() {
        return "Image{" +
                "userId='" + userId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", view='" + view + '\'' +
                '}';
    }
}
