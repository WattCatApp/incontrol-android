package no.redbird.libincontrol.data.jlr.services;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceParameterTest {

    private final String key = "CHARGE_NOW_SETTING";
    private final String value = "FORCE_OFF";
    private final String jsonValue = "{\"timers\":[{\"timerIndex\":11,\"departureTimerDefinition\":{\"timerType\":\"BOTHCHARGEANDPRECONDITION\",\"departureTime\":{\"hour\":10,\"minute\":0},\"timerTarget\":{\"singleDayOrRepeatSchedule\":{\"day\":10,\"month\":9,\"year\":2019}}}}]}";
    private final ServiceParameter parameterAsString = new ServiceParameter(key, value);
    private final ServiceParameter parameterAsJsonObject = new ServiceParameter(key, jsonValue);

    @Test
    public void getKey() {
        assertEquals("Incorrect key",
                key, parameterAsString.getKey());
    }

    @Test
    public void getValue() {
        assertTrue("Json parameter is null",
                parameterAsJsonObject.getValue() != null);
    }

    @Test
    public void getValueAsString() {
        assertEquals("Incorrect value",
                value, parameterAsString.getValueAsString());
    }
}