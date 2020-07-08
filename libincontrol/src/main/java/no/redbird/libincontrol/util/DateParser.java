package no.redbird.libincontrol.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import no.redbird.libincontrol.data.jlr.vehicle.departures.DepartureTimer;
import no.redbird.libincontrol.data.jlr.vehicle.departures.SingleDayTimer;

public class DateParser {

    private DateParser() {
        // No instance
    }

    @Nullable
    public static Date jlrTimestampToDate(@Nullable String timestamp) {
        if (timestamp != null) {
            try {
                return new SimpleDateFormat("y-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH)
                        .parse(timestamp);
            } catch (ParseException e) {
                return null;
            }
        }

        return null;
    }

    @Nullable
    public static Date guardianModeTimestampToDate(@Nullable String timestamp) {
        if (timestamp != null) {
            try {
                return new SimpleDateFormat("y-MM-dd'T'HH:mm:ssX", Locale.ENGLISH)
                        .parse(timestamp);
            } catch (ParseException e) {
                return null;
            }
        }

        return null;
    }

    @NonNull
    public static Date getDateFromDepartureTimer(DepartureTimer departureTimer) {
        Date departureTimerDate = new Date();

        if (departureTimer.getTimerTarget().getSingleDayTimer() != null) {
            // we have a single day departure.
            departureTimerDate = getDateFromSingleDayDepartureTimer(departureTimer);
        } else if (departureTimer.getTimerTarget().getRepeatTimer() != null) {
            // we have a repeated departure
            departureTimerDate = getDateFromRepeatedScheduleTimer(departureTimer);
        }

        if (departureTimerDate != null) {
            return departureTimerDate;
        } else {
            return new Date();
        }
    }

    @Nullable
    public static Date getDateFromSingleDayDepartureTimer(DepartureTimer departureTimer) {
        try {
            SingleDayTimer singleDayTimer = departureTimer.getTimerTarget().getSingleDayTimer();
            if (singleDayTimer != null) {
                String departureTimerDateString = String.format(Locale.ENGLISH, "%d-%d.%d %d:%d",
                        singleDayTimer.getYear(),
                        singleDayTimer.getMonth(),
                        singleDayTimer.getDay(),
                        departureTimer.getDepartureTime().getHour(),
                        departureTimer.getDepartureTime().getMinute());
                return new SimpleDateFormat("y-M.d H:m", Locale.ENGLISH)
                        .parse(departureTimerDateString);
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    @Nullable
    public static Date getDateFromRepeatedScheduleTimer(DepartureTimer departureTimer) {
        try {
            String departureTimerDateString = String.format(Locale.ENGLISH, "%d:%d",
                    departureTimer.getDepartureTime().getHour(),
                    departureTimer.getDepartureTime().getMinute());
            return new SimpleDateFormat("H:m", Locale.ENGLISH)
                    .parse(departureTimerDateString);
        } catch (Exception ex) {
            return null;
        }
    }
}
