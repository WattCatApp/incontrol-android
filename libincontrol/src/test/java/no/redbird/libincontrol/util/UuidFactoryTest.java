package no.redbird.libincontrol.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class UuidFactoryTest {

    @Test
    public void generateDeviceId_assertCorrectFormatReturned() {
        String knownGoodDeviceId = "5539b0b1-0c0a-47ee-97b6-ab1b2cd806f5";
        String generatedDeviceId = UuidFactory.generateDeviceId();

        assertEquals("Generated Device ID is incorrectly formatted",
                knownGoodDeviceId.length(), generatedDeviceId.length());
    }
}