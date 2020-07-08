package no.redbird.libincontrol.data.jlr.geocode;

import com.google.gson.annotations.SerializedName;

public class ReverseGeoCodeResponse {

    @SerializedName("formattedAddress")
    private final
    String formattedAddress;

    public ReverseGeoCodeResponse(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }
}