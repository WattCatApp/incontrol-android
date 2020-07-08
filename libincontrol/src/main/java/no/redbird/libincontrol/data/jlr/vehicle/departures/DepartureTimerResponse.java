package no.redbird.libincontrol.data.jlr.vehicle.departures;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DepartureTimerResponse {

    @SerializedName("timers")
    private List<DepartureTimer> departureTimers;

    public List<DepartureTimer> getDepartureTimers() {
        return departureTimers;
    }
}
