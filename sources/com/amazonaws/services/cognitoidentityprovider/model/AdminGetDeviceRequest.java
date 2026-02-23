package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminGetDeviceRequest extends AmazonWebServiceRequest implements Serializable {
    private String deviceKey;
    private String userPoolId;
    private String username;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminGetDeviceRequest)) {
            return false;
        }
        AdminGetDeviceRequest adminGetDeviceRequest = (AdminGetDeviceRequest) obj;
        if ((adminGetDeviceRequest.getDeviceKey() == null) ^ (getDeviceKey() == null)) {
            return false;
        }
        if (adminGetDeviceRequest.getDeviceKey() != null && !adminGetDeviceRequest.getDeviceKey().equals(getDeviceKey())) {
            return false;
        }
        if ((adminGetDeviceRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminGetDeviceRequest.getUserPoolId() != null && !adminGetDeviceRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminGetDeviceRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        return adminGetDeviceRequest.getUsername() == null || adminGetDeviceRequest.getUsername().equals(getUsername());
    }

    public String getDeviceKey() {
        return this.deviceKey;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return (((((getDeviceKey() == null ? 0 : getDeviceKey().hashCode()) + 31) * 31) + (getUserPoolId() == null ? 0 : getUserPoolId().hashCode())) * 31) + (getUsername() != null ? getUsername().hashCode() : 0);
    }

    public void setDeviceKey(String str) {
        this.deviceKey = str;
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
        if (getDeviceKey() != null) {
            sb.append("DeviceKey: " + getDeviceKey() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminGetDeviceRequest withDeviceKey(String str) {
        this.deviceKey = str;
        return this;
    }

    public AdminGetDeviceRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminGetDeviceRequest withUsername(String str) {
        this.username = str;
        return this;
    }
}
