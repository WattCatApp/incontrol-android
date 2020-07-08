package no.redbird.libincontrol.data.jlr.contactinfo;

import com.google.gson.annotations.SerializedName;

public class ContactInfo {
    @SerializedName("key")
    private final String key;
    @SerializedName("value")
    private final String value;
    @SerializedName("type")
    private final String type;

    public ContactInfo(String key, String value, String type) {
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
