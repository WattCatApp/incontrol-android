package no.redbird.libincontrol.data.jlr.vehicle.wakeuptime;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.Date;

import no.redbird.libincontrol.util.DateParser;

public class WakeupTimeScheduledWakeup {

    @Nullable
    @SerializedName("wakeupTime")
    private String wakeupTime;

    @SerializedName("scheduleAcceptanceEnd")
    private String scheduleAcceptanceEnd;

    @SerializedName("wakeupAcceptanceEnd")
    private String wakeupAcceptanceEnd;

    public WakeupTimeScheduledWakeup(@Nullable String wakeupTime, String scheduleAcceptanceEnd,
                                     String wakeupAcceptanceEnd) {
        this.wakeupTime = wakeupTime;
        this.scheduleAcceptanceEnd = scheduleAcceptanceEnd;
        this.wakeupAcceptanceEnd = wakeupAcceptanceEnd;
    }

    @Nullable
    public Date getWakeupTime() {
        if (wakeupTime != null) {
            return DateParser.jlrTimestampToDate(wakeupTime);
        }
        return null;
    }

    public boolean isWakeupTimeSet() {
        return wakeupTime != null;
    }

    @Nullable
    public Date getScheduleAcceptanceEnd() {
        return DateParser.jlrTimestampToDate(scheduleAcceptanceEnd);
    }

    @Nullable
    public Date getVehicleSleepDate() {
        Date acceptanceEndFromApi = DateParser.jlrTimestampToDate(scheduleAcceptanceEnd);
        // add 48 hours to the schedule acceptance end
        Calendar calendar = Calendar.getInstance();
        if (acceptanceEndFromApi != null) {
            calendar.setTime(acceptanceEndFromApi);
            calendar.add(Calendar.HOUR_OF_DAY, 48);
            return calendar.getTime();
        } else {
            return null;
        }
    }

    @Nullable
    public Date getWakeupAcceptanceEnd() {
        return DateParser.jlrTimestampToDate(wakeupAcceptanceEnd);
    }
}


