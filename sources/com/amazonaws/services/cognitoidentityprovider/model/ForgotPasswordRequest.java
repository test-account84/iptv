package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ForgotPasswordRequest extends AmazonWebServiceRequest implements Serializable {
    private AnalyticsMetadataType analyticsMetadata;
    private String clientId;
    private Map clientMetadata;
    private String secretHash;
    private UserContextDataType userContextData;
    private String username;

    public ForgotPasswordRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (!this.clientMetadata.containsKey(str)) {
            this.clientMetadata.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public ForgotPasswordRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ForgotPasswordRequest)) {
            return false;
        }
        ForgotPasswordRequest forgotPasswordRequest = (ForgotPasswordRequest) obj;
        if ((forgotPasswordRequest.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (forgotPasswordRequest.getClientId() != null && !forgotPasswordRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if ((forgotPasswordRequest.getSecretHash() == null) ^ (getSecretHash() == null)) {
            return false;
        }
        if (forgotPasswordRequest.getSecretHash() != null && !forgotPasswordRequest.getSecretHash().equals(getSecretHash())) {
            return false;
        }
        if ((forgotPasswordRequest.getUserContextData() == null) ^ (getUserContextData() == null)) {
            return false;
        }
        if (forgotPasswordRequest.getUserContextData() != null && !forgotPasswordRequest.getUserContextData().equals(getUserContextData())) {
            return false;
        }
        if ((forgotPasswordRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (forgotPasswordRequest.getUsername() != null && !forgotPasswordRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((forgotPasswordRequest.getAnalyticsMetadata() == null) ^ (getAnalyticsMetadata() == null)) {
            return false;
        }
        if (forgotPasswordRequest.getAnalyticsMetadata() != null && !forgotPasswordRequest.getAnalyticsMetadata().equals(getAnalyticsMetadata())) {
            return false;
        }
        if ((forgotPasswordRequest.getClientMetadata() == null) ^ (getClientMetadata() == null)) {
            return false;
        }
        return forgotPasswordRequest.getClientMetadata() == null || forgotPasswordRequest.getClientMetadata().equals(getClientMetadata());
    }

    public AnalyticsMetadataType getAnalyticsMetadata() {
        return this.analyticsMetadata;
    }

    public String getClientId() {
        return this.clientId;
    }

    public Map getClientMetadata() {
        return this.clientMetadata;
    }

    public String getSecretHash() {
        return this.secretHash;
    }

    public UserContextDataType getUserContextData() {
        return this.userContextData;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return (((((((((((getClientId() == null ? 0 : getClientId().hashCode()) + 31) * 31) + (getSecretHash() == null ? 0 : getSecretHash().hashCode())) * 31) + (getUserContextData() == null ? 0 : getUserContextData().hashCode())) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getAnalyticsMetadata() == null ? 0 : getAnalyticsMetadata().hashCode())) * 31) + (getClientMetadata() != null ? getClientMetadata().hashCode() : 0);
    }

    public void setAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setClientMetadata(Map map) {
        this.clientMetadata = map;
    }

    public void setSecretHash(String str) {
        this.secretHash = str;
    }

    public void setUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getSecretHash() != null) {
            sb.append("SecretHash: " + getSecretHash() + ",");
        }
        if (getUserContextData() != null) {
            sb.append("UserContextData: " + getUserContextData() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getAnalyticsMetadata() != null) {
            sb.append("AnalyticsMetadata: " + getAnalyticsMetadata() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public ForgotPasswordRequest withAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
        return this;
    }

    public ForgotPasswordRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public ForgotPasswordRequest withClientMetadata(Map map) {
        this.clientMetadata = map;
        return this;
    }

    public ForgotPasswordRequest withSecretHash(String str) {
        this.secretHash = str;
        return this;
    }

    public ForgotPasswordRequest withUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
        return this;
    }

    public ForgotPasswordRequest withUsername(String str) {
        this.username = str;
        return this;
    }
}
