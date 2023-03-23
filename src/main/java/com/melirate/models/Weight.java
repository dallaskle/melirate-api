package com.melirate.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Weight {

    private int weightId;
    private User user;
    private LocalDateTime timestamp;
    private double bodyWeight;
    private double fat;
    private double muscle;
    private double hydration;

    public int getWeightId() {
        return weightId;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getBodyWeight() {
        return bodyWeight;
    }

    public double getFat() {
        return fat;
    }

    public double getMuscle() {
        return muscle;
    }

    public double getHydration() {
        return hydration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight = (Weight) o;
        return getWeightId() == weight.getWeightId() && Double.compare(weight.getBodyWeight(), getBodyWeight()) == 0 && Double.compare(weight.getFat(), getFat()) == 0 && Double.compare(weight.getMuscle(), getMuscle()) == 0 && Double.compare(weight.getHydration(), getHydration()) == 0 && Objects.equals(getUser(), weight.getUser()) && Objects.equals(getTimestamp(), weight.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWeightId(), getUser(), getTimestamp(), getBodyWeight(), getFat(), getMuscle(), getHydration());
    }

    @Override
    public String toString() {
        return "Weight{" +
                "weightId=" + weightId +
                ", user=" + user +
                ", timestamp=" + timestamp +
                ", bodyWeight=" + bodyWeight +
                ", fat=" + fat +
                ", muscle=" + muscle +
                ", hydration=" + hydration +
                '}';
    }
}
