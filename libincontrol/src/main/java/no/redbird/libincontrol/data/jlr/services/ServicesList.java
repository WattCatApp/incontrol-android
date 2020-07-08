package no.redbird.libincontrol.data.jlr.services;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ServicesList {

    @SerializedName("services")
    private List<String> services;

    public List<String> getServices() {
        return services;
    }
}
