package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UserPoolClientDescription implements Serializable {
    private String clientId;
    private String clientName;
    private String userPoolId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserPoolClientDescription)) {
            return false;
        }
        UserPoolClientDescription userPoolClientDescription = (UserPoolClientDescription) obj;
        if ((userPoolClientDescription.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (userPoolClientDescription.getClientId() != null && !userPoolClientDescription.getClientId().equals(getClientId())) {
            return false;
        }
        if ((userPoolClientDescription.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (userPoolClientDescription.getUserPoolId() != null && !userPoolClientDescription.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((userPoolClientDescription.getClientName() == null) ^ (getClientName() == null)) {
            return false;
        }
        return userPoolClientDescription.getClientName() == null || userPoolClientDescription.getClientName().equals(getClientName());
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getClientName() {
        return this.clientName;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        return (((((getClientId() == null ? 0 : getClientId().hashCode()) + 31) * 31) + (getUserPoolId() == null ? 0 : getUserPoolId().hashCode())) * 31) + (getClientName() != null ? getClientName().hashCode() : 0);
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setClientName(String str) {
        this.clientName = str;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getClientName() != null) {
            sb.append("ClientName: " + getClientName());
        }
        sb.append("}");
        return sb.toString();
    }

    public UserPoolClientDescription withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public UserPoolClientDescription withClientName(String str) {
        this.clientName = str;
        return this;
    }

    public UserPoolClientDescription withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
