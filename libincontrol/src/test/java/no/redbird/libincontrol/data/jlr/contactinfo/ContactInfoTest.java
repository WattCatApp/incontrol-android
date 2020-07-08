package no.redbird.libincontrol.data.jlr.contactinfo;

import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContactInfoTest {

    @Test
    public void getContactInfo_givenApiData_assertCorrectParsing() {
        Gson gson = new Gson();

        String apiSample = "{\"key\":\"roadSideAssistanceData\",\"value\":\"+4780031055\",\"type\":\"PHONENUMBER\"}";

        ContactInfo contactInfo = gson.fromJson(apiSample, ContactInfo.class);

        assertEquals("roadSideAssistanceData", contactInfo.getKey());
        assertEquals("+4780031055", contactInfo.getValue());
        assertEquals("PHONENUMBER", contactInfo.getType());
    }

}