package no.redbird.libincontrol.data.jlr.vehicle.trips;

import com.google.gson.annotations.SerializedName;

public class RouteDetails {

    @SerializedName("totalWaypoints")
    int totalWaypoints;

    @SerializedName("boundingBox")
    BoundingBox boundingBox;

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }
}
