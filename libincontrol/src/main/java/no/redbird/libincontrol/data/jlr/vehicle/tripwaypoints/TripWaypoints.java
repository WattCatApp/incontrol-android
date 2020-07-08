package no.redbird.libincontrol.data.jlr.vehicle.tripwaypoints;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Contains a list of waypoints for a given trip
 */
public class TripWaypoints {

    @SerializedName("waypoints")
    List<TripWaypoint> waypointList;

    public List<TripWaypoint> getWaypointList() {
        return waypointList;
    }
}
