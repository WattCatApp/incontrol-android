package no.redbird.libincontrol.data.jlr.guardianmode;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import no.redbird.libincontrol.util.DateParser;

public class GuardianModeStatus {

    @SerializedName("status")
    private Status status;

    @SerializedName("endTime")
    String endTime;

    public Status getStatus() {
        return status;
    }

    @Nullable
    public Date getEndTime() {
        return DateParser.jlrTimestampToDate(endTime);
    }

}
