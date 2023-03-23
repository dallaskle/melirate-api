package com.melirate.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Image {

    private int imageId;
    private User user;
    private LocalDateTime timestamp;
    private String imageUrl;
    private View view;

    public int getImageId() {
        return imageId;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public View getView() {
        return view;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return getImageId() == image.getImageId() && Objects.equals(getUser(), image.getUser()) && Objects.equals(getTimestamp(), image.getTimestamp()) && Objects.equals(getImageUrl(), image.getImageUrl()) && getView() == image.getView();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getImageId(), getUser(), getTimestamp(), getImageUrl(), getView());
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageId=" + imageId +
                ", user=" + user +
                ", timestamp=" + timestamp +
                ", imageUrl='" + imageUrl + '\'' +
                ", view=" + view +
                '}';
    }
}
