package no.redbird.libincontrol.data.jlr.vehicle.tripwaypoints;

import com.google.gson.annotations.SerializedName;

/**
 * A single trip waypoint
 */
public class TripWaypoint {

    @SerializedName("timestamp")
    String timestamp;

    @SerializedName("odometer")
    long odometer;

    @SerializedName("position")
    TripWaypointPosition position;

    public TripWaypointPosition getPosition() {
        return position;
    }
}
