package no.redbird.libincontrol.data.jlr.vehicle.wakeuptime;

import org.junit.Test;

import java.util.Date;

import no.redbird.libincontrol.util.DateParser;

import static org.junit.Assert.*;

public class WakeupTimeScheduledWakeupTest {

    private final WakeupTimeScheduledWakeup scheduledWakeup = new WakeupTimeScheduledWakeup(null,
            "2019-10-20T05:41:53+0000",
            "2019-12-05T05:41:53+0000");

    @Test
    public void isWakeupTimeSet_givenNullWakeupTime_assertFalse() {
        assertFalse("Wakeup timer should not be set",
                scheduledWakeup.isWakeupTimeSet());
    }

    @Test
    public void getScheduleAcceptanceEnd_assertCorrectValueReturned() {
        Date realScheduleAcceptanceEnd = DateParser.jlrTimestampToDate("2019-10-20T05:41:53+0000");

        assertEquals(realScheduleAcceptanceEnd, scheduledWakeup.getScheduleAcceptanceEnd());
    }

    @Test
    public void getVehicleSleepDate_assert48HoursAddedDaysAdded() {
        Date realScheduleAcceptanceEnd = DateParser.jlrTimestampToDate("2019-10-22T05:41:53+0000");

        assertEquals(realScheduleAcceptanceEnd, scheduledWakeup.getVehicleSleepDate());
    }

}