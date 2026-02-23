package com.amazonaws.mobile.client;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UserStateDetails {
    private final Map details;
    private Exception exception;
    private final UserState userState;

    public UserStateDetails(UserState userState, Map map) {
        this.userState = userState;
        this.details = map;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UserStateDetails)) {
            return super.equals(obj);
        }
        UserStateDetails userStateDetails = (UserStateDetails) obj;
        if (!this.userState.equals(userStateDetails.userState)) {
            return false;
        }
        Map map = userStateDetails.details;
        Map map2 = this.details;
        if (map == map2) {
            return true;
        }
        if (map2 == null) {
            return false;
        }
        return map2.equals(map);
    }

    public Map getDetails() {
        return this.details;
    }

    public Exception getException() {
        return this.exception;
    }

    public UserState getUserState() {
        return this.userState;
    }

    public void setException(Exception exc) {
        this.exception = exc;
    }
}
