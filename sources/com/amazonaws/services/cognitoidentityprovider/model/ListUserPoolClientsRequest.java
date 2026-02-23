package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListUserPoolClientsRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer maxResults;
    private String nextToken;
    private String userPoolId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListUserPoolClientsRequest)) {
            return false;
        }
        ListUserPoolClientsRequest listUserPoolClientsRequest = (ListUserPoolClientsRequest) obj;
        if ((listUserPoolClientsRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (listUserPoolClientsRequest.getUserPoolId() != null && !listUserPoolClientsRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((listUserPoolClientsRequest.getMaxResults() == null) ^ (getMaxResults() == null)) {
            return false;
        }
        if (listUserPoolClientsRequest.getMaxResults() != null && !listUserPoolClientsRequest.getMaxResults().equals(getMaxResults())) {
            return false;
        }
        if ((listUserPoolClientsRequest.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return listUserPoolClientsRequest.getNextToken() == null || listUserPoolClientsRequest.getNextToken().equals(getNextToken());
    }

    public Integer getMaxResults() {
        return this.maxResults;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        return (((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getMaxResults() == null ? 0 : getMaxResults().hashCode())) * 31) + (getNextToken() != null ? getNextToken().hashCode() : 0);
    }

    public void setMaxResults(Integer num) {
        this.maxResults = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getMaxResults() != null) {
            sb.append("MaxResults: " + getMaxResults() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListUserPoolClientsRequest withMaxResults(Integer num) {
        this.maxResults = num;
        return this;
    }

    public ListUserPoolClientsRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public ListUserPoolClientsRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
