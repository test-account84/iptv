package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminEnableUserRequest extends AmazonWebServiceRequest implements Serializable {
    private String userPoolId;
    private String username;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminEnableUserRequest)) {
            return false;
        }
        AdminEnableUserRequest adminEnableUserRequest = (AdminEnableUserRequest) obj;
        if ((adminEnableUserRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminEnableUserRequest.getUserPoolId() != null && !adminEnableUserRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminEnableUserRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        return adminEnableUserRequest.getUsername() == null || adminEnableUserRequest.getUsername().equals(getUsername());
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return (((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getUsername() != null ? getUsername().hashCode() : 0);
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminEnableUserRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminEnableUserRequest withUsername(String str) {
        this.username = str;
        return this;
    }
}
