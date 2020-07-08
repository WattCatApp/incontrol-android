package no.redbird.libincontrol.data.jlr.vehicle.status;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import no.redbird.libincontrol.data.jlr.vehicle.VehicleAlert;

import static org.junit.Assert.*;

public class VehicleStatusJsonResponseTest {

    @Test
    public void getUpdateTime_givenTimeStamp_assertDateReturned() {
        List<VehicleStatusItem> statusItems = new ArrayList<>();
        List<VehicleAlert> alerts = new ArrayList<>();
        String timestamp = "2019-06-14T16:20:10+0000";

        VehicleStatusJsonResponse response = new VehicleStatusJsonResponse(new VehicleStatuses(statusItems, statusItems),
                alerts, timestamp);

        assertNotNull("Timestamp is null", response.getUpdateTime());
    }

    @Test
    public void getVehicleAlerts_givenAlert_assertCorrectReturnValue() {
        List<VehicleStatusItem> statusItems = new ArrayList<>();
        List<VehicleAlert> alerts = new ArrayList<>();
        alerts.add(new VehicleAlert("PRECONDITIONING_STOPPED", "true", false,
                "2019-06-10T18:13:09+0000"));
        String timestamp = "2019-06-14T16:20:10+0000";

        VehicleStatusJsonResponse response = new VehicleStatusJsonResponse(new VehicleStatuses(statusItems,statusItems),
                alerts, timestamp);


        assertEquals("Incorrect number of alerts returned,", 1,
                response.getVehicleAlerts().size());
    }

}