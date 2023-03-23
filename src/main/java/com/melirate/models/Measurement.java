package com.melirate.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Measurement {

    private int measurementId;
    private User user;
    private LocalDateTime timestamp;
    private double chest;
    private double shoulders;
    private double stomach;
    private double thighs;
    private double calves;
    private double arms;

    public int getMeasurementId() {
        return measurementId;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getChest() {
        return chest;
    }

    public double getShoulders() {
        return shoulders;
    }

    public double getStomach() {
        return stomach;
    }

    public double getThighs() {
        return thighs;
    }

    public double getCalves() {
        return calves;
    }

    public double getArms() {
        return arms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return getMeasurementId() == that.getMeasurementId() && Double.compare(that.getChest(), getChest()) == 0 && Double.compare(that.getShoulders(), getShoulders()) == 0 && Double.compare(that.getStomach(), getStomach()) == 0 && Double.compare(that.getThighs(), getThighs()) == 0 && Double.compare(that.getCalves(), getCalves()) == 0 && Double.compare(that.getArms(), getArms()) == 0 && Objects.equals(getUser(), that.getUser()) && Objects.equals(getTimestamp(), that.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMeasurementId(), getUser(), getTimestamp(), getChest(), getShoulders(), getStomach(), getThighs(), getCalves(), getArms());
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "measurementId=" + measurementId +
                ", user=" + user +
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
