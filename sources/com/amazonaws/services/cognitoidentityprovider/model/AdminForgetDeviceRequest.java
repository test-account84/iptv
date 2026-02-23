package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminForgetDeviceRequest extends AmazonWebServiceRequest implements Serializable {
    private String deviceKey;
    private String userPoolId;
    private String username;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminForgetDeviceRequest)) {
            return false;
        }
        AdminForgetDeviceRequest adminForgetDeviceRequest = (AdminForgetDeviceRequest) obj;
        if ((adminForgetDeviceRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminForgetDeviceRequest.getUserPoolId() != null && !adminForgetDeviceRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminForgetDeviceRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminForgetDeviceRequest.getUsername() != null && !adminForgetDeviceRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminForgetDeviceRequest.getDeviceKey() == null) ^ (getDeviceKey() == null)) {
            return false;
        }
        return adminForgetDeviceRequest.getDeviceKey() == null || adminForgetDeviceRequest.getDeviceKey().equals(getDeviceKey());
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
        return (((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getDeviceKey() != null ? getDeviceKey().hashCode() : 0);
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
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getDeviceKey() != null) {
            sb.append("DeviceKey: " + getDeviceKey());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminForgetDeviceRequest withDeviceKey(String str) {
        this.deviceKey = str;
        return this;
    }

    public AdminForgetDeviceRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminForgetDeviceRequest withUsername(String str) {
        this.username = str;
        return this;
    }
}
