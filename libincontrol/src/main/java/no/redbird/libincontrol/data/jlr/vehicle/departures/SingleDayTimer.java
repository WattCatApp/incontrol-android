package no.redbird.libincontrol.data.jlr.vehicle.departures;

import com.google.gson.annotations.SerializedName;

public class SingleDayTimer {

    @SerializedName("day")
    private final int day;
    @SerializedName("month")
    private final int month;
    @SerializedName("year")
    private final int year;

    public SingleDayTimer(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
