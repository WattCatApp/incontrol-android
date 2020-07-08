package no.redbird.libincontrol.data.jlr.vehicle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class VehicleAlertTest {

    private final static String KEY = "PRECONDITIONING_STARTED";
    private final static String VALUE = "true";
    private final static boolean ACTIVE = true;
    private final static String LAST_UPDATED_TIME = "2019-05-21T07:40:33+0000";

    private final VehicleAlert alert = new VehicleAlert(KEY, VALUE, ACTIVE, LAST_UPDATED_TIME);

    @Test
    public void getKey_givenVehicleAlert_assertKeyCorrect() {
        assertEquals("key is incorrect", KEY, alert.getKey());
    }

    @Test
    public void getValue_givenVehicleAlert_assertCorrectValue() {
        assertEquals("value is incorrect", VALUE, alert.getValue());
    }

    @Test
    public void getActive_givenVehicleAlert_assertCorrectActive() {
        assertEquals("active indicator is incorrect", ACTIVE,
                alert.getActive());
    }

    @Test
    public void equals_givenIdenticalAlert_assertEquals() {
        VehicleAlert secondAlert = new VehicleAlert(KEY, VALUE, ACTIVE, LAST_UPDATED_TIME);
        assertTrue("Comparison incorrect",
                alert.equals(secondAlert));
    }

    @Test
    public void hashCode_givenDifferentAlert_assertDifferentHashCode() {
        VehicleAlert secondAlert = new VehicleAlert("PRECONDITIONING_STOPPED", VALUE,
                ACTIVE, LAST_UPDATED_TIME);
        assertNotEquals("Hashcodes are identical when they should be different",
                alert.hashCode(), secondAlert.hashCode());
    }

    @Test
    public void compareTo_givenDifferentTimestamps_assertCorrectComparison() {
        VehicleAlert secondAlert = new VehicleAlert(KEY, VALUE, ACTIVE,
                "2019-05-21T02:40:33+0000");

        assertEquals("incorrect comparison result",
                1, alert.compareTo(secondAlert));
    }




}