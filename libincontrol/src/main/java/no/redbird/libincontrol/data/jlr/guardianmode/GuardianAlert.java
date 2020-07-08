package no.redbird.libincontrol.data.jlr.guardianmode;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import no.redbird.libincontrol.util.DateParser;

public class GuardianAlert {

    @SerializedName("status")
    private Status mStatus;
    @SerializedName("created")
    private String mCreatedTime;
    @SerializedName("violation")
    private String mViolationTime;

    public GuardianAlert(Status status, String createdTime, String violationTime) {
        mStatus = status;
        mCreatedTime = createdTime;
        mViolationTime = violationTime;
    }

    public Status getStatus() {
        return mStatus;
    }

    public Date getCreatedTime() {
        return DateParser.jlrTimestampToDate(mCreatedTime);
    }

    public Date getViolationTime() {
        return DateParser.guardianModeTimestampToDate(mViolationTime);
    }

    public boolean isEmpty() {
        return (mCreatedTime == null || mViolationTime == null
                || mCreatedTime.isEmpty() || mViolationTime.isEmpty());
    }
}
