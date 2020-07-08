package no.redbird.libincontrol.data.jlr.vehicle.tripwaypoints;

import com.google.gson.annotations.SerializedName;

/**
 * Position for a single trip waypoint
 */
public class TripWaypointPosition {

    @SerializedName("latitude")
    Double latitude;

    @SerializedName("longitude")
    Double longitude;

    @SerializedName("heading")
    int heading;

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
