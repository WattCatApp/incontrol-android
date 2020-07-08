package no.redbird.libincontrol.data.jlr.vehicle.trips;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class TripPosition {

    @SerializedName("latitude")
    Double latitude;

    @SerializedName("longitude")
    Double longitude;

    @SerializedName("address")
    String address;

    @SerializedName("postalCode")
    String postalCode;

    @SerializedName("city")
    String city;

    @SerializedName("region")
    String region;

    @SerializedName("country")
    String country;

    @Nullable
    public String getCity() {
        return city;
    }

    @Nullable
    public String getRegion() {
        return region;
    }

    @Nullable
    public String getAddress() {
        return address;
    }
}
