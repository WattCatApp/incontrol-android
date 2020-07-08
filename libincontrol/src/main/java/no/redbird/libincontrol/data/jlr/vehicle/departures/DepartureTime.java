package no.redbird.libincontrol.data.jlr.vehicle.departures;

import com.google.gson.annotations.SerializedName;

public class DepartureTime {

    @SerializedName("hour")
    private int hour;

    @SerializedName("minute")
    private int minute;


    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}
