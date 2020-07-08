package no.redbird.libincontrol.data.jlr.vehicle.trips;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class TripSummary {

    @SerializedName("id")
    long id;

    @Nullable
    @SerializedName("name")
    String name;

    @Nullable
    @SerializedName("category")
    String category;

    @SerializedName("routeDetails")
    RouteDetails routeDetails;

    @SerializedName("tripDetails")
    TripDetails tripDetails;

    public long getId() {
        return id;
    }

    public TripDetails getTripDetails() {
        return tripDetails;
    }

    public RouteDetails getRouteDetails() {
        return routeDetails;
    }
}
