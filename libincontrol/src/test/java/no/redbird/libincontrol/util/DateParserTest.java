package no.redbird.libincontrol.util;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import no.redbird.libincontrol.data.jlr.vehicle.departures.DepartureTime;
import no.redbird.libincontrol.data.jlr.vehicle.departures.DepartureTimer;
import no.redbird.libincontrol.data.jlr.vehicle.departures.SingleDayTimer;
import no.redbird.libincontrol.data.jlr.vehicle.departures.TimerTarget;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class DateParserTest {

    @Mock
    private DepartureTimer mDepartureTimer;

    @Mock
    private TimerTarget mTimerTarget;

    @Mock
    private SingleDayTimer mSingleDayTimer;

    @Mock
    private DepartureTime mDepartureTime;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void jlrTimestampToDate_givenValidTimestamp_returnsCorrectDateObject() {

        String timestamp = "2019-05-23T07:08:35+0000";
        Date parsedDate = DateParser.jlrTimestampToDate(timestamp);

        assertNotNull("parsed date object is null", parsedDate);

        // verify date values
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        Calendar cal = Calendar.getInstance(timeZone);
        cal.setTime(parsedDate);
        int hour = cal.get(Calendar.HOUR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        assertEquals("parsed hour is incorrect", 7, hour);
        assertEquals("parsed day is incorrect", 23, day);
    }



    @Test
    public void getDateFromSingleDayDepartureTimer_givenTimer_assertCorrectDateReturned() {
        when(mDepartureTimer.getTimerTarget()).thenReturn(mTimerTarget);
        when(mTimerTarget.getSingleDayTimer()).thenReturn(mSingleDayTimer);
        when(mDepartureTimer.getDepartureTime()).thenReturn(mDepartureTime);

        when(mSingleDayTimer.getYear()).thenReturn(2019);
        when(mSingleDayTimer.getMonth()).thenReturn(3);
        when(mSingleDayTimer.getDay()).thenReturn(12);
        when(mDepartureTime.getHour()).thenReturn(13);
        when(mDepartureTime.getMinute()).thenReturn(37);

        Date parsedDate = DateParser.getDateFromSingleDayDepartureTimer(mDepartureTimer);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parsedDate);

        assertEquals("Incorrect year", 2019,
                calendar.get(Calendar.YEAR));
        assertEquals("Incorrect month", 2,
                calendar.get(Calendar.MONTH));
        assertEquals("Incorrect day", 12,
                calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals("Incorrect hour", 13,
                calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals("Incorrect minute", 37,
                calendar.get(Calendar.MINUTE));
    }

    @Test
    public void getDateFromSingleDayDepartureTimer_givenInvalidData_assertNullReturned() {
        when(mDepartureTimer.getTimerTarget()).thenReturn(mTimerTarget);
        when(mTimerTarget.getSingleDayTimer()).thenReturn(null);

        assertNull("Parsed date was not null",
                DateParser.getDateFromSingleDayDepartureTimer(mDepartureTimer));
    }

    @Test
    public void guardianModeTimestampToDate_givenGuardianModeTimestamp_assertNonNullResponse() {
        String timestamp = "2020-06-24T11:29:03Z";
        Date parsedTimestamp = DateParser.guardianModeTimestampToDate(timestamp);
        assertNotNull("Could not parse Guardian mode timestamp",
                parsedTimestamp);
    }

    @Test
    public void getDateFromRepeatedScheduleTimer_givenTimer_assertCorrectDateReturned() {
        when(mDepartureTimer.getTimerTarget()).thenReturn(mTimerTarget);
        when(mDepartureTimer.getDepartureTime()).thenReturn(mDepartureTime);

        when(mDepartureTime.getHour()).thenReturn(2);
        when(mDepartureTime.getMinute()).thenReturn(45);

        Date parsedDate = DateParser.getDateFromRepeatedScheduleTimer(mDepartureTimer);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parsedDate);

        assertEquals("Incorrect hour", 2,
                calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals("Incorrect minute", 45,
                calendar.get(Calendar.MINUTE));
    }

}