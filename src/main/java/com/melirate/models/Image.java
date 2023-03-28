package com.melirate.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

@DynamoDBTable(tableName = "Images")
public class Image {

    private String imageId;
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

    @DynamoDBRangeKey(attributeName = "image_id")
    public String getImageId() {
        return imageId;
    }

    @DynamoDBAttribute(attributeName = "timestamp")
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

    public void setImageId(String imageId) {
        this.imageId = imageId;
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
        return getImageId() == image.getImageId() && Objects.equals(getUserId(), image.getUserId()) && Objects.equals(getTimestamp(), image.getTimestamp()) && Objects.equals(getImageUrl(), image.getImageUrl()) && getView() == image.getView();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getImageId(), getUserId(), getTimestamp(), getImageUrl(), getView());
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageId=" + imageId +
                ", user=" + userId +
                ", timestamp=" + timestamp +
                ", imageUrl='" + imageUrl + '\'' +
                ", view=" + view +
                '}';
    }
}
