package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DescribeUserPoolResult implements Serializable {
    private UserPoolType userPool;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeUserPoolResult)) {
            return false;
        }
        DescribeUserPoolResult describeUserPoolResult = (DescribeUserPoolResult) obj;
        if ((describeUserPoolResult.getUserPool() == null) ^ (getUserPool() == null)) {
            return false;
        }
        return describeUserPoolResult.getUserPool() == null || describeUserPoolResult.getUserPool().equals(getUserPool());
    }

    public UserPoolType getUserPool() {
        return this.userPool;
    }

    public int hashCode() {
        return 31 + (getUserPool() == null ? 0 : getUserPool().hashCode());
    }

    public void setUserPool(UserPoolType userPoolType) {
        this.userPool = userPoolType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPool() != null) {
            sb.append("UserPool: " + getUserPool());
        }
        sb.append("}");
        return sb.toString();
    }

    public DescribeUserPoolResult withUserPool(UserPoolType userPoolType) {
        this.userPool = userPoolType;
        return this;
    }
}
