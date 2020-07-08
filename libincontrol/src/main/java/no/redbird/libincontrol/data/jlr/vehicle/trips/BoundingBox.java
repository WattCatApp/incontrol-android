package no.redbird.libincontrol.data.jlr.vehicle.trips;

import com.google.gson.annotations.SerializedName;

public class BoundingBox {

    @SerializedName("minLongitude")
    Double minLong;

    @SerializedName("minLatitude")
    Double minLat;

    @SerializedName("maxLongitude")
    Double maxLong;

    @SerializedName("maxLatitude")
    Double maxLat;

    public Double getMaxLat() {
        return maxLat;
    }

    public Double getMaxLong() {
        return maxLong;
    }

    public Double getMinLat() {
        return minLat;
    }

    public Double getMinLong() {
        return minLong;
    }
}
