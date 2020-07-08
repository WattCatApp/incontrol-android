package no.redbird.libincontrol.data.jlr.vehicle.departures;

import com.google.gson.annotations.SerializedName;

public class RepeatScheduleTimer {

    @SerializedName("monday")
    private final boolean monday;

    @SerializedName("tuesday")
    private final boolean tuesday;

    @SerializedName("wednesday")
    private final boolean wednesday;

    @SerializedName("thursday")
    private final boolean thursday;

    @SerializedName("friday")
    private final boolean friday;

    @SerializedName("saturday")
    private final boolean saturday;

    @SerializedName("sunday")
    private final boolean sunday;

    public RepeatScheduleTimer(boolean monday, boolean tuesday, boolean wednesday,
                               boolean thursday, boolean friday, boolean saturday,
                               boolean sunday) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public boolean isMonday() {
        return monday;
    }

    public boolean isTuesday() {
        return tuesday;
    }

    public boolean isWednesday() {
        return wednesday;
    }

    public boolean isThursday() {
        return thursday;
    }

    public boolean isFriday() {
        return friday;
    }

    public boolean isSaturday() {
        return saturday;
    }

    public boolean isSunday() {
        return sunday;
    }
}
