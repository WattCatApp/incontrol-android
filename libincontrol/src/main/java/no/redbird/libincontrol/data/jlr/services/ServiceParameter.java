package no.redbird.libincontrol.data.jlr.services;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import no.redbird.libincontrol.util.InControlApi;

public class ServiceParameter {

    @SerializedName("key")
    private String key;
    @SerializedName("value")
    private String value;

    public ServiceParameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public JsonObject getValue() {
        return InControlApi.SERVICE.getServiceParametersFromResponse(value);
    }

    public String getValueAsString() {
        return value;
    }
}
