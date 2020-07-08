package no.redbird.libincontrol.data.jlr.vehicle;

import com.google.gson.annotations.SerializedName;

public class VehicleJsonResponse {

    @SerializedName("vehicles")
    private final Vehicle[] vehicles;

    public VehicleJsonResponse(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }
}
