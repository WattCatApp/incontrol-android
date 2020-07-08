package no.redbird.libincontrol.data.jlr.service;

import com.google.gson.annotations.SerializedName;

public class JlrAuthToken {

    @SerializedName("token")
    private final String token;

    public JlrAuthToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}

