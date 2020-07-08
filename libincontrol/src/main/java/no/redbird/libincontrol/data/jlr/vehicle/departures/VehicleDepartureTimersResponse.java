package no.redbird.libincontrol.data.jlr.vehicle.departures;

import com.google.gson.annotations.SerializedName;

public class VehicleDepartureTimersResponse {

    @SerializedName("departureTimerSetting")
    private DepartureTimerResponse timers;

    public DepartureTimerResponse getTimers() {
        return timers;
    }
}
