package no.redbird.libincontrol.data.jlr.vehicle;

import com.google.gson.annotations.SerializedName;

public class Vehicle {

    @SerializedName("userId")
    private final String userId;

    @SerializedName("vin")
    private final String vin;

    @SerializedName("role")
    private final String role;

    public Vehicle(String userId, String vin, String role) {
        this.userId = userId;
        this.vin = vin;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getVin() {
        return vin;
    }

    public String getRole() {
        return role;
    }
}
