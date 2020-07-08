package no.redbird.libincontrol.data.jlr.vehicle.trips;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TripsResponse {

    @SerializedName("trips")
    private List<TripSummary> trips;

    public TripsResponse(List<TripSummary> trips) {
        this.trips = trips;
    }


    public List<TripSummary> getTrips() {
        return trips;
    }
}
