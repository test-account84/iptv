package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminListDevicesRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer limit;
    private String paginationToken;
    private String userPoolId;
    private String username;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminListDevicesRequest)) {
            return false;
        }
        AdminListDevicesRequest adminListDevicesRequest = (AdminListDevicesRequest) obj;
        if ((adminListDevicesRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminListDevicesRequest.getUserPoolId() != null && !adminListDevicesRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminListDevicesRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminListDevicesRequest.getUsername() != null && !adminListDevicesRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminListDevicesRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (adminListDevicesRequest.getLimit() != null && !adminListDevicesRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((adminListDevicesRequest.getPaginationToken() == null) ^ (getPaginationToken() == null)) {
            return false;
        }
        return adminListDevicesRequest.getPaginationToken() == null || adminListDevicesRequest.getPaginationToken().equals(getPaginationToken());
    }

    public Integer getLimit() {
        return this.limit;
    }

    public String getPaginationToken() {
        return this.paginationToken;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return (((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getLimit() == null ? 0 : getLimit().hashCode())) * 31) + (getPaginationToken() != null ? getPaginationToken().hashCode() : 0);
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public void setPaginationToken(String str) {
        this.paginationToken = str;
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
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getPaginationToken() != null) {
            sb.append("PaginationToken: " + getPaginationToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminListDevicesRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public AdminListDevicesRequest withPaginationToken(String str) {
        this.paginationToken = str;
        return this;
    }

    public AdminListDevicesRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminListDevicesRequest withUsername(String str) {
        this.username = str;
        return this;
    }
}
