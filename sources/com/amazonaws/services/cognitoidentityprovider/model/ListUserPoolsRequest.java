package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListUserPoolsRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer maxResults;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListUserPoolsRequest)) {
            return false;
        }
        ListUserPoolsRequest listUserPoolsRequest = (ListUserPoolsRequest) obj;
        if ((listUserPoolsRequest.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        if (listUserPoolsRequest.getNextToken() != null && !listUserPoolsRequest.getNextToken().equals(getNextToken())) {
            return false;
        }
        if ((listUserPoolsRequest.getMaxResults() == null) ^ (getMaxResults() == null)) {
            return false;
        }
        return listUserPoolsRequest.getMaxResults() == null || listUserPoolsRequest.getMaxResults().equals(getMaxResults());
    }

    public Integer getMaxResults() {
        return this.maxResults;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        return (((getNextToken() == null ? 0 : getNextToken().hashCode()) + 31) * 31) + (getMaxResults() != null ? getMaxResults().hashCode() : 0);
    }

    public void setMaxResults(Integer num) {
        this.maxResults = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken() + ",");
        }
        if (getMaxResults() != null) {
            sb.append("MaxResults: " + getMaxResults());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListUserPoolsRequest withMaxResults(Integer num) {
        this.maxResults = num;
        return this;
    }

    public ListUserPoolsRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
