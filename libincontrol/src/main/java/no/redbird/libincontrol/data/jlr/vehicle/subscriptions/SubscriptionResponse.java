package no.redbird.libincontrol.data.jlr.vehicle.subscriptions;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubscriptionResponse {

    @SerializedName("subscriptionPackages")
    private List<Subscription> subscriptions;

    public SubscriptionResponse(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }
}
