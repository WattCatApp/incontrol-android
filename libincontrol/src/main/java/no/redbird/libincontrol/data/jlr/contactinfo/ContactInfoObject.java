package no.redbird.libincontrol.data.jlr.contactinfo;

import com.google.gson.annotations.SerializedName;

public class ContactInfoObject {

    @SerializedName("contactInfos")
    private ContactInfo[] contactInfos;

    public ContactInfo[] getContactInfos() {
        return contactInfos;
    }
}
