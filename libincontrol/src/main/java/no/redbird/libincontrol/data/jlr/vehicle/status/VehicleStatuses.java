package no.redbird.libincontrol.data.jlr.vehicle.status;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VehicleStatuses {
    @SerializedName("coreStatus")
    private final List<VehicleStatusItem> coreStatusList;
    @SerializedName("evStatus")
    private final List<VehicleStatusItem> evStatusList;

    public VehicleStatuses(List<VehicleStatusItem> coreStatusList,
                           List<VehicleStatusItem> evStatusList) {
        this.coreStatusList = coreStatusList;
        this.evStatusList = evStatusList;
    }

    public List<VehicleStatusItem> getCoreStatusList() {
        return coreStatusList;
    }

    public List<VehicleStatusItem> getEvStatusList() {
        return evStatusList;
    }
}
