package no.redbird.libincontrol.data.jlr.services;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceStatusResponseTest {

    private ServiceStatusResponse response;


    @Before
    public void setUp() {
        Gson gson = new Gson();
        String jsonString = "{'status':'Failed','statusTimestamp':'2020-01-15T07:37:49+0000','startTime':'2020-01-15T07:37:37+0000','serviceType':'ECC','failureReason':'NegativeAcknowledge','failureDescription':'climateModeNotCorrect','customerServiceId':'2553500311_1571241257965_46_@NGTP','vehicleId':'ABCDEF123512','active':false,'initiator':'USER','eventTrigger':null,'serviceCommand':null,'serviceParameters':[{'key':'PRECONDITIONING','value':'STOP'}]}";
        response = gson.fromJson(jsonString, ServiceStatusResponse.class);
    }

    @Test
    public void getStatus_givenFailed_assertFailedReturned() {
        assertEquals("Failed", response.getStatus());
    }

    @Test
    public void isActive_givenFinished_assertFalseReturned() {
        assertFalse(response.isActive());
    }

    @Test
    public void getFailureDescription_givenApiSample_returnsMatch() {
        assertEquals("climateModeNotCorrect", response.getFailureDescription());
    }
}