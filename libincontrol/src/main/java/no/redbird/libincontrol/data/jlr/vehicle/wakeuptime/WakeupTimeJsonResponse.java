package no.redbird.libincontrol.data.jlr.vehicle.wakeuptime;

import com.google.gson.annotations.SerializedName;

import no.redbird.libincontrol.util.InControlApi;

public class WakeupTimeJsonResponse {

    @SerializedName("wakeupTime")
    private String wakeupTime;

    @SerializedName("state")
    private String state;

    @SerializedName("scheduleWakeup")
    private WakeupTimeScheduledWakeup scheduleWakeup;

    public WakeupTimeJsonResponse(String wakeupTime, String state,
                                  WakeupTimeScheduledWakeup scheduleWakeup) {
        this.wakeupTime = wakeupTime;
        this.state = state;
        this.scheduleWakeup = scheduleWakeup;
    }

    public boolean isWithinScheduleAcceptanceWindow() {
        return (state.equals(InControlApi.WAKEUP_TIMER.RECEIVING_SCHEDULE_ACCEPTANCE_WINDOW));
    }

    public String getState() {
        return state;
    }

    public WakeupTimeScheduledWakeup getScheduleWakeup() {
        return scheduleWakeup;
    }

    public String getWakeupTime() {
        return wakeupTime;
    }
}
