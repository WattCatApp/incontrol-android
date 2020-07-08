package no.redbird.libincontrol.data.jlr.vehicle.departures;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import no.redbird.libincontrol.util.DateParser;

public class DepartureTimer implements Comparable<DepartureTimer> {

    @SerializedName("timerIndex")
    private final int timerIndex;

    @SerializedName("timerType")
    private final TimerType timerType;

    @SerializedName("departureTime")
    private final DepartureTime departureTime;

    @Nullable
    @SerializedName("timerTarget")
    private final TimerTarget timerTarget;

    public DepartureTimer(int timerIndex, TimerType timerType, DepartureTime departureTime,
                          TimerTarget timerTarget) {
        this.timerIndex = timerIndex;
        this.timerType = timerType;
        this.departureTime = departureTime;
        this.timerTarget = timerTarget;
    }

    public int getTimerIndex() {
        return timerIndex;
    }

    public TimerType getTimerType() {
        return timerType;
    }

    public DepartureTime getDepartureTime() {
        return departureTime;
    }

    public TimerTarget getTimerTarget() {
        return timerTarget;
    }

    public boolean isActive() {
        return !timerType.getKey().equals("OFF");
    }

    @Override
    public int compareTo(DepartureTimer comparedTimer) {
        // Compare single departure timers by date, and repeated departure timer by next occurrence.
        Date comparedTimerDate = DateParser.getDateFromDepartureTimer(comparedTimer);
        Date thisTimerDate = DateParser.getDateFromDepartureTimer(this);

        return thisTimerDate.compareTo(comparedTimerDate);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        return timerIndex == ((DepartureTimer) obj).getTimerIndex();
    }

    @Override
    public int hashCode() {
        return timerIndex;
    }
}
