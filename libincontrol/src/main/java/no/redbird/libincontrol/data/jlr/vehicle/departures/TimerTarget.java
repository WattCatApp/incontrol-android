package no.redbird.libincontrol.data.jlr.vehicle.departures;

import com.google.gson.annotations.SerializedName;

public class TimerTarget {

    @SerializedName("singleDay")
    private SingleDayTimer singleDayTimer;

    @SerializedName("repeatSchedule")
    private RepeatScheduleTimer repeatTimer;


    public SingleDayTimer getSingleDayTimer() {
        return singleDayTimer;
    }

    public RepeatScheduleTimer getRepeatTimer() {
        return repeatTimer;
    }
}
