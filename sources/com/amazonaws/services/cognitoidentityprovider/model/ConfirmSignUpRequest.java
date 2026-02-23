package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ConfirmSignUpRequest extends AmazonWebServiceRequest implements Serializable {
    private AnalyticsMetadataType analyticsMetadata;
    private String clientId;
    private Map clientMetadata;
    private String confirmationCode;
    private Boolean forceAliasCreation;
    private String secretHash;
    private UserContextDataType userContextData;
    private String username;

    public ConfirmSignUpRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (!this.clientMetadata.containsKey(str)) {
            this.clientMetadata.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public ConfirmSignUpRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConfirmSignUpRequest)) {
            return false;
        }
        ConfirmSignUpRequest confirmSignUpRequest = (ConfirmSignUpRequest) obj;
        if ((confirmSignUpRequest.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (confirmSignUpRequest.getClientId() != null && !confirmSignUpRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if ((confirmSignUpRequest.getSecretHash() == null) ^ (getSecretHash() == null)) {
            return false;
        }
        if (confirmSignUpRequest.getSecretHash() != null && !confirmSignUpRequest.getSecretHash().equals(getSecretHash())) {
            return false;
        }
        if ((confirmSignUpRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (confirmSignUpRequest.getUsername() != null && !confirmSignUpRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((confirmSignUpRequest.getConfirmationCode() == null) ^ (getConfirmationCode() == null)) {
            return false;
        }
        if (confirmSignUpRequest.getConfirmationCode() != null && !confirmSignUpRequest.getConfirmationCode().equals(getConfirmationCode())) {
            return false;
        }
        if ((confirmSignUpRequest.getForceAliasCreation() == null) ^ (getForceAliasCreation() == null)) {
            return false;
        }
        if (confirmSignUpRequest.getForceAliasCreation() != null && !confirmSignUpRequest.getForceAliasCreation().equals(getForceAliasCreation())) {
            return false;
        }
        if ((confirmSignUpRequest.getAnalyticsMetadata() == null) ^ (getAnalyticsMetadata() == null)) {
            return false;
        }
        if (confirmSignUpRequest.getAnalyticsMetadata() != null && !confirmSignUpRequest.getAnalyticsMetadata().equals(getAnalyticsMetadata())) {
            return false;
        }
        if ((confirmSignUpRequest.getUserContextData() == null) ^ (getUserContextData() == null)) {
            return false;
        }
        if (confirmSignUpRequest.getUserContextData() != null && !confirmSignUpRequest.getUserContextData().equals(getUserContextData())) {
            return false;
        }
        if ((confirmSignUpRequest.getClientMetadata() == null) ^ (getClientMetadata() == null)) {
            return false;
        }
        return confirmSignUpRequest.getClientMetadata() == null || confirmSignUpRequest.getClientMetadata().equals(getClientMetadata());
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

    public String getConfirmationCode() {
        return this.confirmationCode;
    }

    public Boolean getForceAliasCreation() {
        return this.forceAliasCreation;
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
        return (((((((((((((((getClientId() == null ? 0 : getClientId().hashCode()) + 31) * 31) + (getSecretHash() == null ? 0 : getSecretHash().hashCode())) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getConfirmationCode() == null ? 0 : getConfirmationCode().hashCode())) * 31) + (getForceAliasCreation() == null ? 0 : getForceAliasCreation().hashCode())) * 31) + (getAnalyticsMetadata() == null ? 0 : getAnalyticsMetadata().hashCode())) * 31) + (getUserContextData() == null ? 0 : getUserContextData().hashCode())) * 31) + (getClientMetadata() != null ? getClientMetadata().hashCode() : 0);
    }

    public Boolean isForceAliasCreation() {
        return this.forceAliasCreation;
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

    public void setConfirmationCode(String str) {
        this.confirmationCode = str;
    }

    public void setForceAliasCreation(Boolean bool) {
        this.forceAliasCreation = bool;
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
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getConfirmationCode() != null) {
            sb.append("ConfirmationCode: " + getConfirmationCode() + ",");
        }
        if (getForceAliasCreation() != null) {
            sb.append("ForceAliasCreation: " + getForceAliasCreation() + ",");
        }
        if (getAnalyticsMetadata() != null) {
            sb.append("AnalyticsMetadata: " + getAnalyticsMetadata() + ",");
        }
        if (getUserContextData() != null) {
            sb.append("UserContextData: " + getUserContextData() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public ConfirmSignUpRequest withAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
        return this;
    }

    public ConfirmSignUpRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public ConfirmSignUpRequest withClientMetadata(Map map) {
        this.clientMetadata = map;
        return this;
    }

    public ConfirmSignUpRequest withConfirmationCode(String str) {
        this.confirmationCode = str;
        return this;
    }

    public ConfirmSignUpRequest withForceAliasCreation(Boolean bool) {
        this.forceAliasCreation = bool;
        return this;
    }

    public ConfirmSignUpRequest withSecretHash(String str) {
        this.secretHash = str;
        return this;
    }

    public ConfirmSignUpRequest withUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
        return this;
    }

    public ConfirmSignUpRequest withUsername(String str) {
        this.username = str;
        return this;
    }
}
