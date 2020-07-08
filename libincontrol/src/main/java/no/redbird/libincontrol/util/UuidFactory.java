package no.redbird.libincontrol.util;

import java.util.UUID;

public class UuidFactory {

    private UuidFactory() {
        // No Instance
    }

    public static String generateDeviceId() {
        return UUID.randomUUID().toString();
    }
}
