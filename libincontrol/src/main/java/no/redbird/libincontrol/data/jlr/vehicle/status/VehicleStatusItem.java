package no.redbird.libincontrol.data.jlr.vehicle.status;

import com.google.gson.annotations.SerializedName;

public class VehicleStatusItem {

    @SerializedName("key")
    private final String key;

    @SerializedName("value")
    private final String value;

    public VehicleStatusItem(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
