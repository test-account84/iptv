package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminUpdateUserAttributesRequest extends AmazonWebServiceRequest implements Serializable {
    private Map clientMetadata;
    private List userAttributes;
    private String userPoolId;
    private String username;

    public AdminUpdateUserAttributesRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (!this.clientMetadata.containsKey(str)) {
            this.clientMetadata.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public AdminUpdateUserAttributesRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminUpdateUserAttributesRequest)) {
            return false;
        }
        AdminUpdateUserAttributesRequest adminUpdateUserAttributesRequest = (AdminUpdateUserAttributesRequest) obj;
        if ((adminUpdateUserAttributesRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminUpdateUserAttributesRequest.getUserPoolId() != null && !adminUpdateUserAttributesRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminUpdateUserAttributesRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminUpdateUserAttributesRequest.getUsername() != null && !adminUpdateUserAttributesRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminUpdateUserAttributesRequest.getUserAttributes() == null) ^ (getUserAttributes() == null)) {
            return false;
        }
        if (adminUpdateUserAttributesRequest.getUserAttributes() != null && !adminUpdateUserAttributesRequest.getUserAttributes().equals(getUserAttributes())) {
            return false;
        }
        if ((adminUpdateUserAttributesRequest.getClientMetadata() == null) ^ (getClientMetadata() == null)) {
            return false;
        }
        return adminUpdateUserAttributesRequest.getClientMetadata() == null || adminUpdateUserAttributesRequest.getClientMetadata().equals(getClientMetadata());
    }

    public Map getClientMetadata() {
        return this.clientMetadata;
    }

    public List getUserAttributes() {
        return this.userAttributes;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return (((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getUserAttributes() == null ? 0 : getUserAttributes().hashCode())) * 31) + (getClientMetadata() != null ? getClientMetadata().hashCode() : 0);
    }

    public void setClientMetadata(Map map) {
        this.clientMetadata = map;
    }

    public void setUserAttributes(Collection collection) {
        if (collection == null) {
            this.userAttributes = null;
        } else {
            this.userAttributes = new ArrayList(collection);
        }
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
        if (getUserAttributes() != null) {
            sb.append("UserAttributes: " + getUserAttributes() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminUpdateUserAttributesRequest withClientMetadata(Map map) {
        this.clientMetadata = map;
        return this;
    }

    public AdminUpdateUserAttributesRequest withUserAttributes(Collection collection) {
        setUserAttributes(collection);
        return this;
    }

    public AdminUpdateUserAttributesRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminUpdateUserAttributesRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public AdminUpdateUserAttributesRequest withUserAttributes(AttributeType... attributeTypeArr) {
        if (getUserAttributes() == null) {
            this.userAttributes = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.userAttributes.add(attributeType);
        }
        return this;
    }
}
