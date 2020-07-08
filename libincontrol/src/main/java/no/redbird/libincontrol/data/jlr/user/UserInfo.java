package no.redbird.libincontrol.data.jlr.user;

import com.google.gson.annotations.SerializedName;

public class UserInfo {

    @SerializedName("userId")
    String userId;

    @SerializedName("loginName")
    String loginName;

    public String getUserId() {
        return userId;
    }
}
