package no.redbird.libincontrol.data.jlr.vehicle.subscriptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubscriptionTest {

    @Test
    public void isActive_givenACTIVATED_assertReturnTrue() {
        Subscription activeSubscription = new Subscription("NOR011AE_J", "ACTIVATED",
                "2022-05-02T17:44:03+0000");

        assertTrue(activeSubscription.isActive());
    }
}