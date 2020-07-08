package no.redbird.libincontrol.data.jlr.vehicle.trips;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import no.redbird.libincontrol.util.DateParser;

public class TripDetails {

    @SerializedName("distance")
    long distance;

    @SerializedName("startOdometer")
    long startOdometer;

    @SerializedName("endOdometer")
    long endOdometer;

    @SerializedName("startTime")
    String startTime;

    @SerializedName("endTime")
    String endTime;

    @SerializedName("startPosition")
    TripPosition startPosition;

    @SerializedName("endPosition")
    TripPosition endPosition;

    @SerializedName("totalEcoScore")
    TripScore totalEcoScore;

    @SerializedName("throttleEcoScore")
    TripScore throttleEcoScore;

    @SerializedName("speedEcoScore")
    TripScore speedEcoScore;

    @SerializedName("brakeEcoScore")
    TripScore brakeEcoScore;

    @SerializedName("averageSpeed")
    Double averageSpeed;

    @SerializedName("averageEnergyConsumption")
    Double averageEnergyConsumption;

    @SerializedName("energyRegenerated")
    Double energyRegenerated;

    public TripPosition getStartPosition() {
        return startPosition;
    }

    public TripPosition getEndPosition() {
        return endPosition;
    }

    @Nullable
    public Date getEndTime() {
        return DateParser.jlrTimestampToDate(endTime);
    }

    @Nullable
    public Date getStartTime() {
        return DateParser.jlrTimestampToDate(startTime);
    }

    public long getStartOdometer() {
        return startOdometer;
    }

    public long getEndOdometer() {
        return endOdometer;
    }

    public long getDistance() {
        return distance;
    }

    public TripScore getTotalEcoScore() {
        return totalEcoScore;
    }

    public Double getAverageSpeed() {
        return averageSpeed;
    }

    @Nullable
    public Double getAverageEnergyConsumption() {
        return averageEnergyConsumption;
    }

    public Double getEnergyRegenerated() {
        return energyRegenerated;
    }
}
