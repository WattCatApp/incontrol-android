package no.redbird.libincontrol.data.jlr.user;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserInfoTest {

    @Test
    public void getUserId() {
        UserInfo info = new UserInfo("124125122", "user@email.com");
        assertEquals("124125122", info.getUserId());
    }

    @Test
    public void getLoginName() {
        UserInfo info = new UserInfo("2151251", "user@email.com");
        assertEquals("user@email.com", info.getLoginName());
    }
}