package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DeleteUserAttributesRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private List userAttributeNames;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteUserAttributesRequest)) {
            return false;
        }
        DeleteUserAttributesRequest deleteUserAttributesRequest = (DeleteUserAttributesRequest) obj;
        if ((deleteUserAttributesRequest.getUserAttributeNames() == null) ^ (getUserAttributeNames() == null)) {
            return false;
        }
        if (deleteUserAttributesRequest.getUserAttributeNames() != null && !deleteUserAttributesRequest.getUserAttributeNames().equals(getUserAttributeNames())) {
            return false;
        }
        if ((deleteUserAttributesRequest.getAccessToken() == null) ^ (getAccessToken() == null)) {
            return false;
        }
        return deleteUserAttributesRequest.getAccessToken() == null || deleteUserAttributesRequest.getAccessToken().equals(getAccessToken());
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public List getUserAttributeNames() {
        return this.userAttributeNames;
    }

    public int hashCode() {
        return (((getUserAttributeNames() == null ? 0 : getUserAttributeNames().hashCode()) + 31) * 31) + (getAccessToken() != null ? getAccessToken().hashCode() : 0);
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setUserAttributeNames(Collection collection) {
        if (collection == null) {
            this.userAttributeNames = null;
        } else {
            this.userAttributeNames = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserAttributeNames() != null) {
            sb.append("UserAttributeNames: " + getUserAttributeNames() + ",");
        }
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public DeleteUserAttributesRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public DeleteUserAttributesRequest withUserAttributeNames(Collection collection) {
        setUserAttributeNames(collection);
        return this;
    }

    public DeleteUserAttributesRequest withUserAttributeNames(String... strArr) {
        if (getUserAttributeNames() == null) {
            this.userAttributeNames = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.userAttributeNames.add(str);
        }
        return this;
    }
}
