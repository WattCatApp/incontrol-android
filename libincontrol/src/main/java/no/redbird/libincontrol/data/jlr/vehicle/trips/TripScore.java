package no.redbird.libincontrol.data.jlr.vehicle.trips;

import com.google.gson.annotations.SerializedName;

public class TripScore {

    @SerializedName("score")
    Double score;

    @SerializedName("scoreStatus")
    String status;

    public TripScore(Double score, String status) {
        this.score = score;
        this.status = status;
    }

    public Double getScore() {
        return score;
    }

    public boolean isValid() {
        return status.equals("VALID");
    }
}
