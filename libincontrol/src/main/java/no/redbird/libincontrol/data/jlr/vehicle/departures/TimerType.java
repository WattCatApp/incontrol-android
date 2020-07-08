package no.redbird.libincontrol.data.jlr.vehicle.departures;

import com.google.gson.annotations.SerializedName;

public class TimerType {

    @SerializedName("key")
    private final String key;

    @SerializedName("value")
    private final boolean value;

    public TimerType(String key, boolean value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public boolean getValue() {
        return value;
    }
}
