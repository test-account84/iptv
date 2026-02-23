package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CreateUserPoolClientResult implements Serializable {
    private UserPoolClientType userPoolClient;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateUserPoolClientResult)) {
            return false;
        }
        CreateUserPoolClientResult createUserPoolClientResult = (CreateUserPoolClientResult) obj;
        if ((createUserPoolClientResult.getUserPoolClient() == null) ^ (getUserPoolClient() == null)) {
            return false;
        }
        return createUserPoolClientResult.getUserPoolClient() == null || createUserPoolClientResult.getUserPoolClient().equals(getUserPoolClient());
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

    public CreateUserPoolClientResult withUserPoolClient(UserPoolClientType userPoolClientType) {
        this.userPoolClient = userPoolClientType;
        return this;
    }
}
