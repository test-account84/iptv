package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SignUpRequest extends AmazonWebServiceRequest implements Serializable {
    private AnalyticsMetadataType analyticsMetadata;
    private String clientId;
    private Map clientMetadata;
    private String password;
    private String secretHash;
    private List userAttributes;
    private UserContextDataType userContextData;
    private String username;
    private List validationData;

    public SignUpRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (!this.clientMetadata.containsKey(str)) {
            this.clientMetadata.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public SignUpRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SignUpRequest)) {
            return false;
        }
        SignUpRequest signUpRequest = (SignUpRequest) obj;
        if ((signUpRequest.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (signUpRequest.getClientId() != null && !signUpRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if ((signUpRequest.getSecretHash() == null) ^ (getSecretHash() == null)) {
            return false;
        }
        if (signUpRequest.getSecretHash() != null && !signUpRequest.getSecretHash().equals(getSecretHash())) {
            return false;
        }
        if ((signUpRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (signUpRequest.getUsername() != null && !signUpRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((signUpRequest.getPassword() == null) ^ (getPassword() == null)) {
            return false;
        }
        if (signUpRequest.getPassword() != null && !signUpRequest.getPassword().equals(getPassword())) {
            return false;
        }
        if ((signUpRequest.getUserAttributes() == null) ^ (getUserAttributes() == null)) {
            return false;
        }
        if (signUpRequest.getUserAttributes() != null && !signUpRequest.getUserAttributes().equals(getUserAttributes())) {
            return false;
        }
        if ((signUpRequest.getValidationData() == null) ^ (getValidationData() == null)) {
            return false;
        }
        if (signUpRequest.getValidationData() != null && !signUpRequest.getValidationData().equals(getValidationData())) {
            return false;
        }
        if ((signUpRequest.getAnalyticsMetadata() == null) ^ (getAnalyticsMetadata() == null)) {
            return false;
        }
        if (signUpRequest.getAnalyticsMetadata() != null && !signUpRequest.getAnalyticsMetadata().equals(getAnalyticsMetadata())) {
            return false;
        }
        if ((signUpRequest.getUserContextData() == null) ^ (getUserContextData() == null)) {
            return false;
        }
        if (signUpRequest.getUserContextData() != null && !signUpRequest.getUserContextData().equals(getUserContextData())) {
            return false;
        }
        if ((signUpRequest.getClientMetadata() == null) ^ (getClientMetadata() == null)) {
            return false;
        }
        return signUpRequest.getClientMetadata() == null || signUpRequest.getClientMetadata().equals(getClientMetadata());
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

    public String getPassword() {
        return this.password;
    }

    public String getSecretHash() {
        return this.secretHash;
    }

    public List getUserAttributes() {
        return this.userAttributes;
    }

    public UserContextDataType getUserContextData() {
        return this.userContextData;
    }

    public String getUsername() {
        return this.username;
    }

    public List getValidationData() {
        return this.validationData;
    }

    public int hashCode() {
        return (((((((((((((((((getClientId() == null ? 0 : getClientId().hashCode()) + 31) * 31) + (getSecretHash() == null ? 0 : getSecretHash().hashCode())) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getPassword() == null ? 0 : getPassword().hashCode())) * 31) + (getUserAttributes() == null ? 0 : getUserAttributes().hashCode())) * 31) + (getValidationData() == null ? 0 : getValidationData().hashCode())) * 31) + (getAnalyticsMetadata() == null ? 0 : getAnalyticsMetadata().hashCode())) * 31) + (getUserContextData() == null ? 0 : getUserContextData().hashCode())) * 31) + (getClientMetadata() != null ? getClientMetadata().hashCode() : 0);
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

    public void setPassword(String str) {
        this.password = str;
    }

    public void setSecretHash(String str) {
        this.secretHash = str;
    }

    public void setUserAttributes(Collection collection) {
        if (collection == null) {
            this.userAttributes = null;
        } else {
            this.userAttributes = new ArrayList(collection);
        }
    }

    public void setUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void setValidationData(Collection collection) {
        if (collection == null) {
            this.validationData = null;
        } else {
            this.validationData = new ArrayList(collection);
        }
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
        if (getPassword() != null) {
            sb.append("Password: " + getPassword() + ",");
        }
        if (getUserAttributes() != null) {
            sb.append("UserAttributes: " + getUserAttributes() + ",");
        }
        if (getValidationData() != null) {
            sb.append("ValidationData: " + getValidationData() + ",");
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

    public SignUpRequest withAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
        return this;
    }

    public SignUpRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public SignUpRequest withClientMetadata(Map map) {
        this.clientMetadata = map;
        return this;
    }

    public SignUpRequest withPassword(String str) {
        this.password = str;
        return this;
    }

    public SignUpRequest withSecretHash(String str) {
        this.secretHash = str;
        return this;
    }

    public SignUpRequest withUserAttributes(Collection collection) {
        setUserAttributes(collection);
        return this;
    }

    public SignUpRequest withUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
        return this;
    }

    public SignUpRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public SignUpRequest withValidationData(Collection collection) {
        setValidationData(collection);
        return this;
    }

    public SignUpRequest withUserAttributes(AttributeType... attributeTypeArr) {
        if (getUserAttributes() == null) {
            this.userAttributes = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.userAttributes.add(attributeType);
        }
        return this;
    }

    public SignUpRequest withValidationData(AttributeType... attributeTypeArr) {
        if (getValidationData() == null) {
            this.validationData = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.validationData.add(attributeType);
        }
        return this;
    }
}
