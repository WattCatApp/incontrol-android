package no.redbird.libincontrol.data.jlr.guardianmode;

import org.junit.Test;

import no.redbird.libincontrol.data.jlr.guardianmode.GuardianAlert;

import static org.junit.Assert.*;


public class GuardianAlertTest {


    @Test
    public void isEmpty_givenNullCreationTime_assertTrue() {
        GuardianAlert alert = new GuardianAlert(null, null, null);
        assertTrue(alert.isEmpty());
    }
}
