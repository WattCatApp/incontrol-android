package no.redbird.libincontrol.data.jlr.services;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ServiceStatusResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("serviceType")
    private String serviceType;

    @SerializedName("failureDescription")
    private String failureDescription;

    @SerializedName("customerServiceId")
    private String serviceId;

    @SerializedName("active")
    private boolean active;

    @SerializedName("serviceParameters")
    private List<ServiceParameter> serviceParameters;

    public String getStatus() {
        return status;
    }

    public String getFailureDescription() {
        return failureDescription;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public boolean isActive() {
        return active;
    }

    public List<ServiceParameter> getServiceParameters() {
        return serviceParameters;
    }
}
