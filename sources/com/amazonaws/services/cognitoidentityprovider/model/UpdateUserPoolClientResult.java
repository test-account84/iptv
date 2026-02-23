package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UpdateUserPoolClientResult implements Serializable {
    private UserPoolClientType userPoolClient;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateUserPoolClientResult)) {
            return false;
        }
        UpdateUserPoolClientResult updateUserPoolClientResult = (UpdateUserPoolClientResult) obj;
        if ((updateUserPoolClientResult.getUserPoolClient() == null) ^ (getUserPoolClient() == null)) {
            return false;
        }
        return updateUserPoolClientResult.getUserPoolClient() == null || updateUserPoolClientResult.getUserPoolClient().equals(getUserPoolClient());
    }

    public UserPoolClientType getUserPoolClient() {
        return this.userPoolClient;
    }

    public int hashCode() {
        return 31 + (getUserPoolClient() == null ? 0 : getUserPoolClient().hashCode());
    }

    public void setUserPoolClient(UserPoolClientType userPoolClientType) {
        this.userPoolClient = userPoolClientType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolClient() != null) {
            sb.append("UserPoolClient: " + getUserPoolClient());
        }
        sb.append("}");
        return sb.toString();
    }

    public UpdateUserPoolClientResult withUserPoolClient(UserPoolClientType userPoolClientType) {
        this.userPoolClient = userPoolClientType;
        return this;
    }
}
