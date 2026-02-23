package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminInitiateAuthRequest extends AmazonWebServiceRequest implements Serializable {
    private AnalyticsMetadataType analyticsMetadata;
    private String authFlow;
    private Map authParameters;
    private String clientId;
    private Map clientMetadata;
    private ContextDataType contextData;
    private String userPoolId;

    public AdminInitiateAuthRequest addAuthParametersEntry(String str, String str2) {
        if (this.authParameters == null) {
            this.authParameters = new HashMap();
        }
        if (!this.authParameters.containsKey(str)) {
            this.authParameters.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public AdminInitiateAuthRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (!this.clientMetadata.containsKey(str)) {
            this.clientMetadata.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public AdminInitiateAuthRequest clearAuthParametersEntries() {
        this.authParameters = null;
        return this;
    }

    public AdminInitiateAuthRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminInitiateAuthRequest)) {
            return false;
        }
        AdminInitiateAuthRequest adminInitiateAuthRequest = (AdminInitiateAuthRequest) obj;
        if ((adminInitiateAuthRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminInitiateAuthRequest.getUserPoolId() != null && !adminInitiateAuthRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminInitiateAuthRequest.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (adminInitiateAuthRequest.getClientId() != null && !adminInitiateAuthRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if ((adminInitiateAuthRequest.getAuthFlow() == null) ^ (getAuthFlow() == null)) {
            return false;
        }
        if (adminInitiateAuthRequest.getAuthFlow() != null && !adminInitiateAuthRequest.getAuthFlow().equals(getAuthFlow())) {
            return false;
        }
        if ((adminInitiateAuthRequest.getAuthParameters() == null) ^ (getAuthParameters() == null)) {
            return false;
        }
        if (adminInitiateAuthRequest.getAuthParameters() != null && !adminInitiateAuthRequest.getAuthParameters().equals(getAuthParameters())) {
            return false;
        }
        if ((adminInitiateAuthRequest.getClientMetadata() == null) ^ (getClientMetadata() == null)) {
            return false;
        }
        if (adminInitiateAuthRequest.getClientMetadata() != null && !adminInitiateAuthRequest.getClientMetadata().equals(getClientMetadata())) {
            return false;
        }
        if ((adminInitiateAuthRequest.getAnalyticsMetadata() == null) ^ (getAnalyticsMetadata() == null)) {
            return false;
        }
        if (adminInitiateAuthRequest.getAnalyticsMetadata() != null && !adminInitiateAuthRequest.getAnalyticsMetadata().equals(getAnalyticsMetadata())) {
            return false;
        }
        if ((adminInitiateAuthRequest.getContextData() == null) ^ (getContextData() == null)) {
            return false;
        }
        return adminInitiateAuthRequest.getContextData() == null || adminInitiateAuthRequest.getContextData().equals(getContextData());
    }

    public AnalyticsMetadataType getAnalyticsMetadata() {
        return this.analyticsMetadata;
    }

    public String getAuthFlow() {
        return this.authFlow;
    }

    public Map getAuthParameters() {
        return this.authParameters;
    }

    public String getClientId() {
        return this.clientId;
    }

    public Map getClientMetadata() {
        return this.clientMetadata;
    }

    public ContextDataType getContextData() {
        return this.contextData;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        return (((((((((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getClientId() == null ? 0 : getClientId().hashCode())) * 31) + (getAuthFlow() == null ? 0 : getAuthFlow().hashCode())) * 31) + (getAuthParameters() == null ? 0 : getAuthParameters().hashCode())) * 31) + (getClientMetadata() == null ? 0 : getClientMetadata().hashCode())) * 31) + (getAnalyticsMetadata() == null ? 0 : getAnalyticsMetadata().hashCode())) * 31) + (getContextData() != null ? getContextData().hashCode() : 0);
    }

    public void setAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
    }

    public void setAuthFlow(AuthFlowType authFlowType) {
        this.authFlow = authFlowType.toString();
    }

    public void setAuthParameters(Map map) {
        this.authParameters = map;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setClientMetadata(Map map) {
        this.clientMetadata = map;
    }

    public void setContextData(ContextDataType contextDataType) {
        this.contextData = contextDataType;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getAuthFlow() != null) {
            sb.append("AuthFlow: " + getAuthFlow() + ",");
        }
        if (getAuthParameters() != null) {
            sb.append("AuthParameters: " + getAuthParameters() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata() + ",");
        }
        if (getAnalyticsMetadata() != null) {
            sb.append("AnalyticsMetadata: " + getAnalyticsMetadata() + ",");
        }
        if (getContextData() != null) {
            sb.append("ContextData: " + getContextData());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminInitiateAuthRequest withAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
        return this;
    }

    public AdminInitiateAuthRequest withAuthFlow(AuthFlowType authFlowType) {
        this.authFlow = authFlowType.toString();
        return this;
    }

    public AdminInitiateAuthRequest withAuthParameters(Map map) {
        this.authParameters = map;
        return this;
    }

    public AdminInitiateAuthRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public AdminInitiateAuthRequest withClientMetadata(Map map) {
        this.clientMetadata = map;
        return this;
    }

    public AdminInitiateAuthRequest withContextData(ContextDataType contextDataType) {
        this.contextData = contextDataType;
        return this;
    }

    public AdminInitiateAuthRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public void setAuthFlow(String str) {
        this.authFlow = str;
    }

    public AdminInitiateAuthRequest withAuthFlow(String str) {
        this.authFlow = str;
        return this;
    }
}
