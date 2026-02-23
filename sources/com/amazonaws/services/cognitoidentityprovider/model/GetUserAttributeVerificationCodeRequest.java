package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetUserAttributeVerificationCodeRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private String attributeName;
    private Map clientMetadata;

    public GetUserAttributeVerificationCodeRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (!this.clientMetadata.containsKey(str)) {
            this.clientMetadata.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GetUserAttributeVerificationCodeRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetUserAttributeVerificationCodeRequest)) {
            return false;
        }
        GetUserAttributeVerificationCodeRequest getUserAttributeVerificationCodeRequest = (GetUserAttributeVerificationCodeRequest) obj;
        if ((getUserAttributeVerificationCodeRequest.getAccessToken() == null) ^ (getAccessToken() == null)) {
            return false;
        }
        if (getUserAttributeVerificationCodeRequest.getAccessToken() != null && !getUserAttributeVerificationCodeRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if ((getUserAttributeVerificationCodeRequest.getAttributeName() == null) ^ (getAttributeName() == null)) {
            return false;
        }
        if (getUserAttributeVerificationCodeRequest.getAttributeName() != null && !getUserAttributeVerificationCodeRequest.getAttributeName().equals(getAttributeName())) {
            return false;
        }
        if ((getUserAttributeVerificationCodeRequest.getClientMetadata() == null) ^ (getClientMetadata() == null)) {
            return false;
        }
        return getUserAttributeVerificationCodeRequest.getClientMetadata() == null || getUserAttributeVerificationCodeRequest.getClientMetadata().equals(getClientMetadata());
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public Map getClientMetadata() {
        return this.clientMetadata;
    }

    public int hashCode() {
        return (((((getAccessToken() == null ? 0 : getAccessToken().hashCode()) + 31) * 31) + (getAttributeName() == null ? 0 : getAttributeName().hashCode())) * 31) + (getClientMetadata() != null ? getClientMetadata().hashCode() : 0);
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setAttributeName(String str) {
        this.attributeName = str;
    }

    public void setClientMetadata(Map map) {
        this.clientMetadata = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
        }
        if (getAttributeName() != null) {
            sb.append("AttributeName: " + getAttributeName() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetUserAttributeVerificationCodeRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public GetUserAttributeVerificationCodeRequest withAttributeName(String str) {
        this.attributeName = str;
        return this;
    }

    public GetUserAttributeVerificationCodeRequest withClientMetadata(Map map) {
        this.clientMetadata = map;
        return this;
    }
}
