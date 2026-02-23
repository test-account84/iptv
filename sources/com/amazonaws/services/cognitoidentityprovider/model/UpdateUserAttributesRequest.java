package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UpdateUserAttributesRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private Map clientMetadata;
    private List userAttributes;

    public UpdateUserAttributesRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (!this.clientMetadata.containsKey(str)) {
            this.clientMetadata.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public UpdateUserAttributesRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateUserAttributesRequest)) {
            return false;
        }
        UpdateUserAttributesRequest updateUserAttributesRequest = (UpdateUserAttributesRequest) obj;
        if ((updateUserAttributesRequest.getUserAttributes() == null) ^ (getUserAttributes() == null)) {
            return false;
        }
        if (updateUserAttributesRequest.getUserAttributes() != null && !updateUserAttributesRequest.getUserAttributes().equals(getUserAttributes())) {
            return false;
        }
        if ((updateUserAttributesRequest.getAccessToken() == null) ^ (getAccessToken() == null)) {
            return false;
        }
        if (updateUserAttributesRequest.getAccessToken() != null && !updateUserAttributesRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if ((updateUserAttributesRequest.getClientMetadata() == null) ^ (getClientMetadata() == null)) {
            return false;
        }
        return updateUserAttributesRequest.getClientMetadata() == null || updateUserAttributesRequest.getClientMetadata().equals(getClientMetadata());
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public Map getClientMetadata() {
        return this.clientMetadata;
    }

    public List getUserAttributes() {
        return this.userAttributes;
    }

    public int hashCode() {
        return (((((getUserAttributes() == null ? 0 : getUserAttributes().hashCode()) + 31) * 31) + (getAccessToken() == null ? 0 : getAccessToken().hashCode())) * 31) + (getClientMetadata() != null ? getClientMetadata().hashCode() : 0);
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserAttributes() != null) {
            sb.append("UserAttributes: " + getUserAttributes() + ",");
        }
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public UpdateUserAttributesRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public UpdateUserAttributesRequest withClientMetadata(Map map) {
        this.clientMetadata = map;
        return this;
    }

    public UpdateUserAttributesRequest withUserAttributes(Collection collection) {
        setUserAttributes(collection);
        return this;
    }

    public UpdateUserAttributesRequest withUserAttributes(AttributeType... attributeTypeArr) {
        if (getUserAttributes() == null) {
            this.userAttributes = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.userAttributes.add(attributeType);
        }
        return this;
    }
}
