package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminCreateUserResult implements Serializable {
    private UserType user;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminCreateUserResult)) {
            return false;
        }
        AdminCreateUserResult adminCreateUserResult = (AdminCreateUserResult) obj;
        if ((adminCreateUserResult.getUser() == null) ^ (getUser() == null)) {
            return false;
        }
        return adminCreateUserResult.getUser() == null || adminCreateUserResult.getUser().equals(getUser());
    }

    public UserType getUser() {
        return this.user;
    }

    public int hashCode() {
        return 31 + (getUser() == null ? 0 : getUser().hashCode());
    }

    public void setUser(UserType userType) {
        this.user = userType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUser() != null) {
            sb.append("User: " + getUser());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminCreateUserResult withUser(UserType userType) {
        this.user = userType;
        return this;
    }
}
