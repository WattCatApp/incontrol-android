package no.redbird.libincontrol.data.jlr.vehicle.position;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class PositionTest {

    private final float lat = 59.916984f;
    private final float lon = 10.727431f;
    private final String timestamp = "2019-06-12T16:25:02+0000";
    private final Position position = new Position(lat, lon, timestamp);

    @Test
    public void getTimestamp_givenPosition_assertCorrectParsing() {
        assertNotNull("Position timestamp is null",
                position.getTimestamp());
        Date date = position.getTimestamp();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        assertEquals("Incorrect year", 2019,
                calendar.get(Calendar.YEAR));
        assertEquals("Incorrect month", 5,
                calendar.get(Calendar.MONTH));
        assertEquals("Incorrect day", 12,
                calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals("Incorrect hour", 16,
                calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals("Incorrect minute", 25,
                calendar.get(Calendar.MINUTE));
    }

    @Test
    public void getLongitude_givenPosition_assertCorrectResponse() {
        assertEquals("Incorrect lon", lon, position.getLongitude(), 0.001);
    }

    @Test
    public void getLatitude_givenPosition_assertCorrectResponse() {
        assertEquals("Incorrect lat", lat, position.getLatitude(), 0.001);
    }
}