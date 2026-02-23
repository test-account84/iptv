package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminListGroupsForUserRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer limit;
    private String nextToken;
    private String userPoolId;
    private String username;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminListGroupsForUserRequest)) {
            return false;
        }
        AdminListGroupsForUserRequest adminListGroupsForUserRequest = (AdminListGroupsForUserRequest) obj;
        if ((adminListGroupsForUserRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminListGroupsForUserRequest.getUsername() != null && !adminListGroupsForUserRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminListGroupsForUserRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminListGroupsForUserRequest.getUserPoolId() != null && !adminListGroupsForUserRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminListGroupsForUserRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (adminListGroupsForUserRequest.getLimit() != null && !adminListGroupsForUserRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((adminListGroupsForUserRequest.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return adminListGroupsForUserRequest.getNextToken() == null || adminListGroupsForUserRequest.getNextToken().equals(getNextToken());
    }

    public Integer getLimit() {
        return this.limit;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return (((((((getUsername() == null ? 0 : getUsername().hashCode()) + 31) * 31) + (getUserPoolId() == null ? 0 : getUserPoolId().hashCode())) * 31) + (getLimit() == null ? 0 : getLimit().hashCode())) * 31) + (getNextToken() != null ? getNextToken().hashCode() : 0);
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
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
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminListGroupsForUserRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public AdminListGroupsForUserRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public AdminListGroupsForUserRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminListGroupsForUserRequest withUsername(String str) {
        this.username = str;
        return this;
    }
}
