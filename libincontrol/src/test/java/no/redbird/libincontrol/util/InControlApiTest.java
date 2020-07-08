package no.redbird.libincontrol.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import no.redbird.libincontrol.data.jlr.service.JlrAuthToken;
import no.redbird.libincontrol.data.jlr.services.ServiceParameter;
import no.redbird.libincontrol.data.jlr.services.ServiceStatusResponse;
import no.redbird.libincontrol.data.jlr.vehicle.departures.DepartureTimer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class InControlApiTest {

    @Mock
    private ServiceParameter mServiceParameter;

    private final String timerResponse = "{\"timers\":[{\"timerIndex\":0,\"departureTimerDefinition\":null}," +
            "{\"timerIndex\":2,\"departureTimerDefinition\":null}]}";

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUnprotectedServiceAuthenticationJsonBody_assertCorrectParsing() {
        String serviceName = "ECC";

        JsonObject authBody = InControlApi.SERVICE
                .getUnprotectedServiceAuthenticationJsonBody(serviceName);

        assertEquals(serviceName, authBody.get("serviceName").getAsString());
        assertEquals("", authBody.get("pin").getAsString());
    }

    @Test
    public void getPrivilegedServiceAuthenticationJsonBody_assertCorrectParsing() {
        String serviceName = InControlApi.SERVICE.SERVICE_RDL;
        String pin = "1926";

        JsonObject authBody = InControlApi.SERVICE.getPrivilegedServiceAuthenticationJsonBody(serviceName,
                pin);

        assertEquals(serviceName, authBody.get("serviceName").getAsString());
        assertEquals(pin, authBody.get("pin").getAsString());
    }

    @Test
    public void getVehicleAttributesBody_assertCorrectness() {
        String nickname = "The Jag";
        String regnumber = "EK10000";

        JsonObject dataObject = InControlApi.SERVICE.getVehicleAttributesBody(regnumber, nickname);

        assertEquals(nickname, dataObject.get("nickname").getAsString());
        assertEquals(regnumber, dataObject.get("registrationNumber").getAsString());
    }

    @Test
    public void getAuthJsonBody_assertCorrectParsing() {
        String username = "user@username.com";
        String password = "abcdef1234";

        JsonObject authBody = InControlApi.AUTH.getAuthJsonBody(username, password);

        assertEquals(username, authBody.get("username").getAsString());
        assertEquals(password, authBody.get("password").getAsString());
        assertEquals("password", authBody.get("grant_type").getAsString());
    }

    @Test
    public void getTokenRefreshJsonBody_assertCorrectParsing() {
        String refresh_token = UuidFactory.generateDeviceId();

        JsonObject authBody = InControlApi.AUTH.getTokenRefreshJsonBody(refresh_token);

        assertEquals(refresh_token, authBody.get("refresh_token").getAsString());
    }

    @Test
    public void getDepartureDeleteJsonBody_givenTokenAndTwoTimers_assertCorrectObjectReturned() {

        JlrAuthToken authToken = new JlrAuthToken(UuidFactory.generateDeviceId());
        List<DepartureTimer> timersToDeleteList = new ArrayList<>();
        timersToDeleteList.add(new DepartureTimer(1, null, null, null));
        timersToDeleteList.add(new DepartureTimer(10, null, null, null));

        JsonObject data = InControlApi.DEPARTURES.getDepartureDeleteJsonBody(authToken,
                timersToDeleteList);

        assertEquals("Incorrect token",
                authToken.getToken(), data.get("token").getAsString());
        assertEquals(2,
                data.getAsJsonObject("departureTimerSetting").
                        getAsJsonArray("timers").size());
    }

    @Test
    public void getServiceParametersFromResponse_givenResponse_assertJsonObjectReturned() {
        JsonObject responseData = InControlApi.SERVICE.getServiceParametersFromResponse(timerResponse);
        assertNotNull("parsed response data is null", responseData);
        JsonArray timers = responseData.getAsJsonArray("timers");
        assertNotNull("timers array is null", timers);
    }

    @Test
    public void getDepartureTimerIndicesFromResponse_givenResponse_assertIndicesReturned() {
        when(mServiceParameter.getKey()).thenReturn("DEPARTURETIMER_SETTINGS");
        when(mServiceParameter.getValue()).thenReturn(InControlApi.SERVICE
                .getServiceParametersFromResponse(timerResponse));

        List<Integer> timerIndices = InControlApi.SERVICE
                .getDepartureTimerIndicesFromServiceParameter(mServiceParameter);

        assertEquals("Incorrect number of indices in result",
                2, timerIndices.size());
    }

    @Test
    public void getGenericTokenBody_givenToken_assertCorrectJsonResponse() {
        JlrAuthToken token = new JlrAuthToken(UuidFactory.generateDeviceId());

        JsonObject tokenBody = InControlApi.SERVICE.getGenericTokenBody(token);

        assertEquals("Token body does not contain correct token data",
                token.getToken(), tokenBody.get("token").getAsString());
    }

    @Test
    public void createSingleDepartureTimer_givenToken_assertCorrectJsonResponse() {

        int year = 2019;
        int month = 2;
        int day = 24;
        int hour = 15;
        int minute = 5;

        JlrAuthToken token = new JlrAuthToken(UuidFactory.generateDeviceId());

        JsonObject data = InControlApi.DEPARTURES.createSingleDepartureTimer(token,
                year, month, day, hour, minute);

        assertEquals("token value is not correct",
                token.getToken(), data.get("token").getAsString());

        String dataAsString = data.toString();

        String apiSample = String.format(Locale.ENGLISH,
                "{\"token\":\"%s\",\"departureTimerSetting\":{\"timers\":[{\"departureTime\":{\"hour\":15,\"minute\":5},\"timerIndex\":50,\"timerTarget\":{\"singleDay\":{\"day\":24,\"month\":2,\"year\":2019}},\"timerType\":{\"key\":\"BOTHCHARGEANDPRECONDITION\",\"value\":true}}]}}", token.getToken());
        assertEquals("Generated data does not match API sample",
                apiSample, dataAsString);
    }

    @Test
    public void createRepeatedDepartureTimer_givenToken_assertCorrectJsonResponse() {
        int hour = 15;
        int minute = 5;

        boolean monday = true;
        boolean tuesday = true;
        boolean wednesday = true;
        boolean thursday = true;
        boolean friday = true;
        boolean saturday = false;
        boolean sunday = false;

        JlrAuthToken token = new JlrAuthToken(UuidFactory.generateDeviceId());

        JsonObject data = InControlApi.DEPARTURES.createRepeatedDepartureTimer(token, hour, minute,
                monday, tuesday, wednesday, thursday, friday, saturday, sunday);

        assertEquals("token value is not correct",
                token.getToken(), data.get("token").getAsString());

        String dataAsString = data.toString();
        String apiSample = String.format(Locale.ENGLISH,
                "{\"token\":\"%s\",\"departureTimerSetting\":{\"timers\":[{\"departureTime\":{\"hour\":15,\"minute\":5},\"timerIndex\":50,\"timerTarget\":{\"repeatSchedule\":{\"monday\":true,\"tuesday\":true,\"wednesday\":true,\"thursday\":true,\"friday\":true,\"saturday\":false,\"sunday\":false}},\"timerType\":{\"key\":\"BOTHCHARGEANDPRECONDITION\",\"value\":true}}]}}", token.getToken());

        assertEquals("Generated data does not match API sample",
                apiSample, dataAsString);
    }

    @Test
    public void getChargingToggleJsonBody_givenApiSample_assertCorrectResponse() {
        JlrAuthToken token = new JlrAuthToken(UuidFactory.generateDeviceId());
        String apiSample = String.format(Locale.ENGLISH,
                "{\"token\":\"%s\",\"serviceParameters\":[{\"key\":\"CHARGE_NOW_SETTING\",\"value\":\"FORCE_OFF\"}]}",
                token.getToken());

        JsonObject data = InControlApi.CHARGING.getChargingToggleJsonBody(token, true);
        String dataString = data.toString();

        assertEquals("Charging control json body does not match API sample",
                apiSample, dataString);
    }

    @Test
    public void getWakeupTimerCreationJsonBody_givenApiSample_assertCorrectParsing() {
        JlrAuthToken token = new JlrAuthToken(UuidFactory.generateDeviceId());
        Date date = new Date();
        String apiSample = String.format(Locale.ENGLISH,
                "{\"serviceCommand\":\"START\",\"startTime\":%d,\"token\":\"%s\"}",
                date.getTime(), token.getToken());

        JsonObject data = InControlApi.WAKEUP_TIMER.getWakeupTimerCreationJsonBody(token, date);
        String dataAsString = data.toString();

        assertEquals("Wakeup timer creation body does not match API sample",
                apiSample, dataAsString);
    }

    @Test
    public void getWakeupTimerDeletionJsonBody_givenApiSample_assertCorrectParsing() {
        JlrAuthToken token = new JlrAuthToken(UuidFactory.generateDeviceId());
        String apiSample = String.format(Locale.ENGLISH,
                "{\"serviceCommand\":\"END\",\"token\":\"%s\"}",
                token.getToken());

        JsonObject data = InControlApi.WAKEUP_TIMER.getWakeupTimerDeletionJsonBody(token);
        String dataAsString = data.toString();

        assertEquals("Wakeup timer deletion body does not match API sample",
                apiSample, dataAsString);
    }

    @Test
    public void getPrivacyModeToggleBody_givenApiSample_assertMatch() {
        JlrAuthToken token = new JlrAuthToken(UuidFactory.generateDeviceId());
        String apiSample = String.format(Locale.ENGLISH,
                "{\"token\":\"%s\",\"serviceCommand\":\"privacySwitch_on\",\"startTime\":null,\"endTime\":null}",
                token.getToken());

        JsonObject data = InControlApi.SERVICE.getPrivacyModeToggleBody(true, token);
        String dataAsString = data.toString();

        assertEquals("Privacy toggle body does not match API sample",
                apiSample, dataAsString);
    }

    @Test
    public void getGuardianModeEnableBody_givenApiSample_assertCorrectMatch() {
        JlrAuthToken token = new JlrAuthToken(UuidFactory.generateDeviceId());
        long expirationTime = 1578171627;
        String apiSample = String.format(Locale.ENGLISH,
                "{\"token\":\"%s\",\"status\":\"ACTIVE\",\"endTime\":%d}",
                token.getToken(), expirationTime);

        JsonObject data = InControlApi.GUARDIAN_MODE.getGuardianModeEnableObject(expirationTime,
                token);
        String dataAsString = data.toString();

        assertEquals(apiSample, dataAsString);
    }

    @Test
    public void getServiceModeBody_givenApiSample_assertMatch() {
        JlrAuthToken token = new JlrAuthToken(UuidFactory.generateDeviceId());
        long expirationTime = 1578171627;
        String apiSample = String.format(Locale.ENGLISH,
                "{\"token\":\"%s\",\"serviceCommand\":\"protectionStrategy_serviceMode\",\"endTime\":%d}",
                token.getToken(), expirationTime);

        JsonObject data = InControlApi.SERVICE.getServiceModeBody(expirationTime, token);
        String dataAsString = data.toString();

        assertEquals(apiSample, dataAsString);
    }

    @Test
    public void getTransportModeBody_givenApiSample_assertMatch() {
        JlrAuthToken token = new JlrAuthToken(UuidFactory.generateDeviceId());
        long expirationTime = 1578171627;
        String apiSample = String.format(Locale.ENGLISH,
                "{\"token\":\"%s\",\"serviceCommand\":\"protectionStrategy_transportMode\",\"endTime\":%d}",
                token.getToken(), expirationTime);

        JsonObject data = InControlApi.SERVICE.getTransportModeBody(expirationTime, token);
        String dataAsString = data.toString();

        assertEquals(apiSample, dataAsString);
    }

    @Test
    public void parseServiceIdentifier_givenServiceUri_assertServiceIdentifierReturned() {
        String serviceId = "2553500311_1578244147154_31_@NGTP";
        String serviceUri = String.format("/vehicles/S1245B1FK1F7452125/services/%s",
                serviceId);

        String paredServiceId = InControlApi.SERVICE.parseServiceIdentifierFromUri(serviceUri);

        assertEquals("Parsed service Id is incorrect", serviceId,
                paredServiceId);
    }

    @Test
    public void getDepartureDeletionIndicesFromServiceStatus_givenDepartureDeleteService_assertCorrectIndexReturned() {
        Gson gson = new Gson();
        String apiSample = "{'status': 'Running', 'statusTimestamp': '2020-01-05T17:09:23+0000', 'startTime': '2020-01-05T17:09:07+0000', 'serviceType': 'CP', 'failureDescription': '', 'customerServiceId': '2553500311_1578244147154_31_@NGTP', 'vehicleId': 'XXDHA2B14K1F72347', 'active': True, 'initiator': 'USER', 'eventTrigger': None, 'serviceCommand': None, 'serviceParameters': [{'key': 'DEPARTURETIMER_SETTINGS', 'value': '{\"timers\":[{\"timerIndex\":1,\"departureTimerDefinition\":null}]}'}]}";

        ServiceStatusResponse response = gson.fromJson(apiSample, ServiceStatusResponse.class);

        List<Integer> timerIndices = InControlApi.DEPARTURES.getDepartureDeletionIndicesFromServiceStatus(response);
        assertTrue("Timer indices is not expected size", timerIndices.size() == 1);
        assertTrue(timerIndices.get(0) == 1);
    }

}