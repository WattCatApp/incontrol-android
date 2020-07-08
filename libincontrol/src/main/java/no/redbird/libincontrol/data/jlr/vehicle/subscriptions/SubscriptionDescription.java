package no.redbird.libincontrol.data.jlr.vehicle.subscriptions;

public class SubscriptionDescription {

    private final String readableName;
    private final String description;

    public SubscriptionDescription(String readableName, String description) {
        this.readableName = readableName;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getReadableName() {
        return readableName;
    }
}
