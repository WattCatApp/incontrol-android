package no.redbird.libincontrol.data.jlr.user;

import com.google.gson.annotations.SerializedName;

public class UserInfo {

    @SerializedName("userId")
    private final String userId;

    @SerializedName("loginName")
    private final String loginName;

    public UserInfo(String userId, String loginName) {
        this.userId = userId;
        this.loginName = loginName;
    }

    public String getUserId() {
        return userId;
    }

    public String getLoginName() {
        return loginName;
    }
}
