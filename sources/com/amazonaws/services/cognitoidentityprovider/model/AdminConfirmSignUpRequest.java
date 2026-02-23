package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminConfirmSignUpRequest extends AmazonWebServiceRequest implements Serializable {
    private Map clientMetadata;
    private String userPoolId;
    private String username;

    public AdminConfirmSignUpRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (!this.clientMetadata.containsKey(str)) {
            this.clientMetadata.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public AdminConfirmSignUpRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminConfirmSignUpRequest)) {
            return false;
        }
        AdminConfirmSignUpRequest adminConfirmSignUpRequest = (AdminConfirmSignUpRequest) obj;
        if ((adminConfirmSignUpRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminConfirmSignUpRequest.getUserPoolId() != null && !adminConfirmSignUpRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminConfirmSignUpRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminConfirmSignUpRequest.getUsername() != null && !adminConfirmSignUpRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminConfirmSignUpRequest.getClientMetadata() == null) ^ (getClientMetadata() == null)) {
            return false;
        }
        return adminConfirmSignUpRequest.getClientMetadata() == null || adminConfirmSignUpRequest.getClientMetadata().equals(getClientMetadata());
    }

    public Map getClientMetadata() {
        return this.clientMetadata;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return (((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getClientMetadata() != null ? getClientMetadata().hashCode() : 0);
    }

    public void setClientMetadata(Map map) {
        this.clientMetadata = map;
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
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminConfirmSignUpRequest withClientMetadata(Map map) {
        this.clientMetadata = map;
        return this;
    }

    public AdminConfirmSignUpRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminConfirmSignUpRequest withUsername(String str) {
        this.username = str;
        return this;
    }
}
