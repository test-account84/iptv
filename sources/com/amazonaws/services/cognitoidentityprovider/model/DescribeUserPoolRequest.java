package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DescribeUserPoolRequest extends AmazonWebServiceRequest implements Serializable {
    private String userPoolId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeUserPoolRequest)) {
            return false;
        }
        DescribeUserPoolRequest describeUserPoolRequest = (DescribeUserPoolRequest) obj;
        if ((describeUserPoolRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        return describeUserPoolRequest.getUserPoolId() == null || describeUserPoolRequest.getUserPoolId().equals(getUserPoolId());
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        return 31 + (getUserPoolId() == null ? 0 : getUserPoolId().hashCode());
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId());
        }
        sb.append("}");
        return sb.toString();
    }

    public DescribeUserPoolRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
