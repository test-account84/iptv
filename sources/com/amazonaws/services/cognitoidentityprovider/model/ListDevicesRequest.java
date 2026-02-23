package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListDevicesRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private Integer limit;
    private String paginationToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListDevicesRequest)) {
            return false;
        }
        ListDevicesRequest listDevicesRequest = (ListDevicesRequest) obj;
        if ((listDevicesRequest.getAccessToken() == null) ^ (getAccessToken() == null)) {
            return false;
        }
        if (listDevicesRequest.getAccessToken() != null && !listDevicesRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if ((listDevicesRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (listDevicesRequest.getLimit() != null && !listDevicesRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((listDevicesRequest.getPaginationToken() == null) ^ (getPaginationToken() == null)) {
            return false;
        }
        return listDevicesRequest.getPaginationToken() == null || listDevicesRequest.getPaginationToken().equals(getPaginationToken());
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public String getPaginationToken() {
        return this.paginationToken;
    }

    public int hashCode() {
        return (((((getAccessToken() == null ? 0 : getAccessToken().hashCode()) + 31) * 31) + (getLimit() == null ? 0 : getLimit().hashCode())) * 31) + (getPaginationToken() != null ? getPaginationToken().hashCode() : 0);
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public void setPaginationToken(String str) {
        this.paginationToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
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

    public ListDevicesRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public ListDevicesRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public ListDevicesRequest withPaginationToken(String str) {
        this.paginationToken = str;
        return this;
    }
}
