package no.redbird.libincontrol.data.jlr.vehicle.subscriptions;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import no.redbird.libincontrol.util.DateParser;

public class Subscription {

    @SerializedName("name")
    private String name;

    @SerializedName("status")
    private String status;

    @SerializedName("expirationDate")
    private String expirationDate;

    public Subscription(String name, String status, String expirationDate) {
        this.name = name;
        this.status = status;
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() {
        return DateParser.jlrTimestampToDate(expirationDate);
    }

    public String getCode() {
        return name;
    }


    public String getStatus() {
        return status;
    }

    public boolean isActive() {
        return status.equals("ACTIVATED");
    }
}
