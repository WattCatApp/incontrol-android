package no.redbird.libincontrol.data.jlr.vehicle.status;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

import no.redbird.libincontrol.data.jlr.vehicle.VehicleAlert;
import no.redbird.libincontrol.util.DateParser;

public class VehicleStatusJsonResponse {

    @SerializedName("vehicleStatus")
    private final VehicleStatuses vehicleStatuses;

    @SerializedName("vehicleAlerts")
    private List<VehicleAlert> vehicleAlerts;

    @SerializedName("lastUpdatedTime")
    private String lastUpdatedTime;

    public VehicleStatusJsonResponse(VehicleStatuses vehicleStatuses,
                                     List<VehicleAlert> vehicleAlerts,
                                     String lastUpdatedTime) {
        this.vehicleStatuses = vehicleStatuses;
        this.vehicleAlerts = vehicleAlerts;
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public VehicleStatuses getVehicleStatuses() {
        return vehicleStatuses;
    }

    public List<VehicleAlert> getVehicleAlerts() {
        return vehicleAlerts;
    }

    public Date getUpdateTime() {
        return DateParser.jlrTimestampToDate(lastUpdatedTime);
    }
}
