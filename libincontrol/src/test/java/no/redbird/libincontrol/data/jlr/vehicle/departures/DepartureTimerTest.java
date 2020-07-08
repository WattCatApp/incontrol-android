package no.redbird.libincontrol.data.jlr.vehicle.departures;

import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepartureTimerTest {

    @Test
    public void isActive() {
        Gson gson = new Gson();
        String disabledDepartureTimerString = "{\n" +
                "    \"departureTimerSetting\": {\n" +
                "        \"timers\": [\n" +
                "            {\n" +
                "                \"timerIndex\": 0,\n" +
                "                \"timerType\": {\n" +
                "                    \"key\": \"OFF\",\n" +
                "                    \"value\": true\n" +
                "                },\n" +
                "                \"departureTime\": {\n" +
                "                    \"hour\": 8,\n" +
                "                    \"minute\": 0\n" +
                "                },\n" +
                "                \"timerTarget\": {\n" +
                "                    \"singleDay\": {\n" +
                "                        \"day\": 13,\n" +
                "                        \"month\": 1,\n" +
                "                        \"year\": 2020\n" +
                "                    },\n" +
                "                    \"repeatSchedule\": null\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"timerIndex\": 1,\n" +
                "                \"timerType\": {\n" +
                "                    \"key\": \"BOTHCHARGEANDPRECONDITION\",\n" +
                "                    \"value\": true\n" +
                "                },\n" +
                "                \"departureTime\": {\n" +
                "                    \"hour\": 21,\n" +
                "                    \"minute\": 5\n" +
                "                },\n" +
                "                \"timerTarget\": {\n" +
                "                    \"singleDay\": {\n" +
                "                        \"day\": 14,\n" +
                "                        \"month\": 1,\n" +
                "                        \"year\": 2020\n" +
                "                    },\n" +
                "                    \"repeatSchedule\": null\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"tariffSettings\": null,\n" +
                "    \"triggerUrl\": null,\n" +
                "    \"triggerUserId\": null,\n" +
                "    \"triggerPassword\": null,\n" +
                "    \"triggerMediaType\": null,\n" +
                "    \"startTime\": null,\n" +
                "    \"endTime\": null,\n" +
                "    \"serviceCommand\": null,\n" +
                "    \"serviceParameters\": null\n" +
                "}";
        VehicleDepartureTimersResponse disabledDepartureResponse = gson.fromJson(disabledDepartureTimerString,
                VehicleDepartureTimersResponse.class);

        assertFalse("Departure timer is not considered disabled",
                disabledDepartureResponse.getTimers().getDepartureTimers().get(0).isActive());
        assertTrue("Departure timer was falsely considered disabled",
                disabledDepartureResponse.getTimers().getDepartureTimers().get(1).isActive());
    }

    @Test
    public void compareTo_assertCorrectComparison() {
        Gson gson = new Gson();
        DepartureTimer firstDepartureTimer = gson.fromJson("{'timerIndex':1,'timerType':{'key':'BOTHCHARGEANDPRECONDITION','value':true},'departureTime':{'hour':20,'minute':0},'timerTarget':{'singleDay':{'day':27,'month':1,'year':2020},'repeatSchedule':null}}", DepartureTimer.class);
        DepartureTimer secondDepartureTimer = gson.fromJson("{'timerIndex':1,'timerType':{'key':'BOTHCHARGEANDPRECONDITION','value':true},'departureTime':{'hour':23,'minute':0},'timerTarget':{'singleDay':{'day':27,'month':1,'year':2020},'repeatSchedule':null}}", DepartureTimer.class);

        assertEquals(-1, firstDepartureTimer.compareTo(secondDepartureTimer));
    }

    @Test
    public void equals_assertEqualsIfTimerIndexAreTheSame() {
        Gson gson = new Gson();
        DepartureTimer firstDepartureTimer = gson.fromJson("{'timerIndex':1,'timerType':{'key':'BOTHCHARGEANDPRECONDITION','value':true},'departureTime':{'hour':20,'minute':0},'timerTarget':{'singleDay':{'day':27,'month':1,'year':2020},'repeatSchedule':null}}", DepartureTimer.class);
        DepartureTimer secondDepartureTimer = gson.fromJson("{'timerIndex':1,'timerType':{'key':'BOTHCHARGEANDPRECONDITION','value':true},'departureTime':{'hour':23,'minute':0},'timerTarget':{'singleDay':{'day':27,'month':1,'year':2020},'repeatSchedule':null}}", DepartureTimer.class);

        assertEquals(firstDepartureTimer, secondDepartureTimer);

    }
}