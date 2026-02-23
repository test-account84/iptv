package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UpdateUserPoolClientRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer accessTokenValidity;
    private List allowedOAuthFlows;
    private Boolean allowedOAuthFlowsUserPoolClient;
    private List allowedOAuthScopes;
    private AnalyticsConfigurationType analyticsConfiguration;
    private Integer authSessionValidity;
    private List callbackURLs;
    private String clientId;
    private String clientName;
    private String defaultRedirectURI;
    private Boolean enablePropagateAdditionalUserContextData;
    private Boolean enableTokenRevocation;
    private List explicitAuthFlows;
    private Integer idTokenValidity;
    private List logoutURLs;
    private String preventUserExistenceErrors;
    private List readAttributes;
    private Integer refreshTokenValidity;
    private List supportedIdentityProviders;
    private TokenValidityUnitsType tokenValidityUnits;
    private String userPoolId;
    private List writeAttributes;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateUserPoolClientRequest)) {
            return false;
        }
        UpdateUserPoolClientRequest updateUserPoolClientRequest = (UpdateUserPoolClientRequest) obj;
        if ((updateUserPoolClientRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getUserPoolId() != null && !updateUserPoolClientRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getClientId() != null && !updateUserPoolClientRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getClientName() == null) ^ (getClientName() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getClientName() != null && !updateUserPoolClientRequest.getClientName().equals(getClientName())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getRefreshTokenValidity() == null) ^ (getRefreshTokenValidity() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getRefreshTokenValidity() != null && !updateUserPoolClientRequest.getRefreshTokenValidity().equals(getRefreshTokenValidity())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getAccessTokenValidity() == null) ^ (getAccessTokenValidity() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getAccessTokenValidity() != null && !updateUserPoolClientRequest.getAccessTokenValidity().equals(getAccessTokenValidity())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getIdTokenValidity() == null) ^ (getIdTokenValidity() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getIdTokenValidity() != null && !updateUserPoolClientRequest.getIdTokenValidity().equals(getIdTokenValidity())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getTokenValidityUnits() == null) ^ (getTokenValidityUnits() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getTokenValidityUnits() != null && !updateUserPoolClientRequest.getTokenValidityUnits().equals(getTokenValidityUnits())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getReadAttributes() == null) ^ (getReadAttributes() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getReadAttributes() != null && !updateUserPoolClientRequest.getReadAttributes().equals(getReadAttributes())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getWriteAttributes() == null) ^ (getWriteAttributes() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getWriteAttributes() != null && !updateUserPoolClientRequest.getWriteAttributes().equals(getWriteAttributes())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getExplicitAuthFlows() == null) ^ (getExplicitAuthFlows() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getExplicitAuthFlows() != null && !updateUserPoolClientRequest.getExplicitAuthFlows().equals(getExplicitAuthFlows())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getSupportedIdentityProviders() == null) ^ (getSupportedIdentityProviders() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getSupportedIdentityProviders() != null && !updateUserPoolClientRequest.getSupportedIdentityProviders().equals(getSupportedIdentityProviders())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getCallbackURLs() == null) ^ (getCallbackURLs() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getCallbackURLs() != null && !updateUserPoolClientRequest.getCallbackURLs().equals(getCallbackURLs())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getLogoutURLs() == null) ^ (getLogoutURLs() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getLogoutURLs() != null && !updateUserPoolClientRequest.getLogoutURLs().equals(getLogoutURLs())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getDefaultRedirectURI() == null) ^ (getDefaultRedirectURI() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getDefaultRedirectURI() != null && !updateUserPoolClientRequest.getDefaultRedirectURI().equals(getDefaultRedirectURI())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getAllowedOAuthFlows() == null) ^ (getAllowedOAuthFlows() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getAllowedOAuthFlows() != null && !updateUserPoolClientRequest.getAllowedOAuthFlows().equals(getAllowedOAuthFlows())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getAllowedOAuthScopes() == null) ^ (getAllowedOAuthScopes() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getAllowedOAuthScopes() != null && !updateUserPoolClientRequest.getAllowedOAuthScopes().equals(getAllowedOAuthScopes())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getAllowedOAuthFlowsUserPoolClient() == null) ^ (getAllowedOAuthFlowsUserPoolClient() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getAllowedOAuthFlowsUserPoolClient() != null && !updateUserPoolClientRequest.getAllowedOAuthFlowsUserPoolClient().equals(getAllowedOAuthFlowsUserPoolClient())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getAnalyticsConfiguration() == null) ^ (getAnalyticsConfiguration() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getAnalyticsConfiguration() != null && !updateUserPoolClientRequest.getAnalyticsConfiguration().equals(getAnalyticsConfiguration())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getPreventUserExistenceErrors() == null) ^ (getPreventUserExistenceErrors() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getPreventUserExistenceErrors() != null && !updateUserPoolClientRequest.getPreventUserExistenceErrors().equals(getPreventUserExistenceErrors())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getEnableTokenRevocation() == null) ^ (getEnableTokenRevocation() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getEnableTokenRevocation() != null && !updateUserPoolClientRequest.getEnableTokenRevocation().equals(getEnableTokenRevocation())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getEnablePropagateAdditionalUserContextData() == null) ^ (getEnablePropagateAdditionalUserContextData() == null)) {
            return false;
        }
        if (updateUserPoolClientRequest.getEnablePropagateAdditionalUserContextData() != null && !updateUserPoolClientRequest.getEnablePropagateAdditionalUserContextData().equals(getEnablePropagateAdditionalUserContextData())) {
            return false;
        }
        if ((updateUserPoolClientRequest.getAuthSessionValidity() == null) ^ (getAuthSessionValidity() == null)) {
            return false;
        }
        return updateUserPoolClientRequest.getAuthSessionValidity() == null || updateUserPoolClientRequest.getAuthSessionValidity().equals(getAuthSessionValidity());
    }

    public Integer getAccessTokenValidity() {
        return this.accessTokenValidity;
    }

    public List getAllowedOAuthFlows() {
        return this.allowedOAuthFlows;
    }

    public Boolean getAllowedOAuthFlowsUserPoolClient() {
        return this.allowedOAuthFlowsUserPoolClient;
    }

    public List getAllowedOAuthScopes() {
        return this.allowedOAuthScopes;
    }

    public AnalyticsConfigurationType getAnalyticsConfiguration() {
        return this.analyticsConfiguration;
    }

    public Integer getAuthSessionValidity() {
        return this.authSessionValidity;
    }

    public List getCallbackURLs() {
        return this.callbackURLs;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getClientName() {
        return this.clientName;
    }

    public String getDefaultRedirectURI() {
        return this.defaultRedirectURI;
    }

    public Boolean getEnablePropagateAdditionalUserContextData() {
        return this.enablePropagateAdditionalUserContextData;
    }

    public Boolean getEnableTokenRevocation() {
        return this.enableTokenRevocation;
    }

    public List getExplicitAuthFlows() {
        return this.explicitAuthFlows;
    }

    public Integer getIdTokenValidity() {
        return this.idTokenValidity;
    }

    public List getLogoutURLs() {
        return this.logoutURLs;
    }

    public String getPreventUserExistenceErrors() {
        return this.preventUserExistenceErrors;
    }

    public List getReadAttributes() {
        return this.readAttributes;
    }

    public Integer getRefreshTokenValidity() {
        return this.refreshTokenValidity;
    }

    public List getSupportedIdentityProviders() {
        return this.supportedIdentityProviders;
    }

    public TokenValidityUnitsType getTokenValidityUnits() {
        return this.tokenValidityUnits;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public List getWriteAttributes() {
        return this.writeAttributes;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getClientId() == null ? 0 : getClientId().hashCode())) * 31) + (getClientName() == null ? 0 : getClientName().hashCode())) * 31) + (getRefreshTokenValidity() == null ? 0 : getRefreshTokenValidity().hashCode())) * 31) + (getAccessTokenValidity() == null ? 0 : getAccessTokenValidity().hashCode())) * 31) + (getIdTokenValidity() == null ? 0 : getIdTokenValidity().hashCode())) * 31) + (getTokenValidityUnits() == null ? 0 : getTokenValidityUnits().hashCode())) * 31) + (getReadAttributes() == null ? 0 : getReadAttributes().hashCode())) * 31) + (getWriteAttributes() == null ? 0 : getWriteAttributes().hashCode())) * 31) + (getExplicitAuthFlows() == null ? 0 : getExplicitAuthFlows().hashCode())) * 31) + (getSupportedIdentityProviders() == null ? 0 : getSupportedIdentityProviders().hashCode())) * 31) + (getCallbackURLs() == null ? 0 : getCallbackURLs().hashCode())) * 31) + (getLogoutURLs() == null ? 0 : getLogoutURLs().hashCode())) * 31) + (getDefaultRedirectURI() == null ? 0 : getDefaultRedirectURI().hashCode())) * 31) + (getAllowedOAuthFlows() == null ? 0 : getAllowedOAuthFlows().hashCode())) * 31) + (getAllowedOAuthScopes() == null ? 0 : getAllowedOAuthScopes().hashCode())) * 31) + (getAllowedOAuthFlowsUserPoolClient() == null ? 0 : getAllowedOAuthFlowsUserPoolClient().hashCode())) * 31) + (getAnalyticsConfiguration() == null ? 0 : getAnalyticsConfiguration().hashCode())) * 31) + (getPreventUserExistenceErrors() == null ? 0 : getPreventUserExistenceErrors().hashCode())) * 31) + (getEnableTokenRevocation() == null ? 0 : getEnableTokenRevocation().hashCode())) * 31) + (getEnablePropagateAdditionalUserContextData() == null ? 0 : getEnablePropagateAdditionalUserContextData().hashCode())) * 31) + (getAuthSessionValidity() != null ? getAuthSessionValidity().hashCode() : 0);
    }

    public Boolean isAllowedOAuthFlowsUserPoolClient() {
        return this.allowedOAuthFlowsUserPoolClient;
    }

    public Boolean isEnablePropagateAdditionalUserContextData() {
        return this.enablePropagateAdditionalUserContextData;
    }

    public Boolean isEnableTokenRevocation() {
        return this.enableTokenRevocation;
    }

    public void setAccessTokenValidity(Integer num) {
        this.accessTokenValidity = num;
    }

    public void setAllowedOAuthFlows(Collection collection) {
        if (collection == null) {
            this.allowedOAuthFlows = null;
        } else {
            this.allowedOAuthFlows = new ArrayList(collection);
        }
    }

    public void setAllowedOAuthFlowsUserPoolClient(Boolean bool) {
        this.allowedOAuthFlowsUserPoolClient = bool;
    }

    public void setAllowedOAuthScopes(Collection collection) {
        if (collection == null) {
            this.allowedOAuthScopes = null;
        } else {
            this.allowedOAuthScopes = new ArrayList(collection);
        }
    }

    public void setAnalyticsConfiguration(AnalyticsConfigurationType analyticsConfigurationType) {
        this.analyticsConfiguration = analyticsConfigurationType;
    }

    public void setAuthSessionValidity(Integer num) {
        this.authSessionValidity = num;
    }

    public void setCallbackURLs(Collection collection) {
        if (collection == null) {
            this.callbackURLs = null;
        } else {
            this.callbackURLs = new ArrayList(collection);
        }
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setClientName(String str) {
        this.clientName = str;
    }

    public void setDefaultRedirectURI(String str) {
        this.defaultRedirectURI = str;
    }

    public void setEnablePropagateAdditionalUserContextData(Boolean bool) {
        this.enablePropagateAdditionalUserContextData = bool;
    }

    public void setEnableTokenRevocation(Boolean bool) {
        this.enableTokenRevocation = bool;
    }

    public void setExplicitAuthFlows(Collection collection) {
        if (collection == null) {
            this.explicitAuthFlows = null;
        } else {
            this.explicitAuthFlows = new ArrayList(collection);
        }
    }

    public void setIdTokenValidity(Integer num) {
        this.idTokenValidity = num;
    }

    public void setLogoutURLs(Collection collection) {
        if (collection == null) {
            this.logoutURLs = null;
        } else {
            this.logoutURLs = new ArrayList(collection);
        }
    }

    public void setPreventUserExistenceErrors(PreventUserExistenceErrorTypes preventUserExistenceErrorTypes) {
        this.preventUserExistenceErrors = preventUserExistenceErrorTypes.toString();
    }

    public void setReadAttributes(Collection collection) {
        if (collection == null) {
            this.readAttributes = null;
        } else {
            this.readAttributes = new ArrayList(collection);
        }
    }

    public void setRefreshTokenValidity(Integer num) {
        this.refreshTokenValidity = num;
    }

    public void setSupportedIdentityProviders(Collection collection) {
        if (collection == null) {
            this.supportedIdentityProviders = null;
        } else {
            this.supportedIdentityProviders = new ArrayList(collection);
        }
    }

    public void setTokenValidityUnits(TokenValidityUnitsType tokenValidityUnitsType) {
        this.tokenValidityUnits = tokenValidityUnitsType;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public void setWriteAttributes(Collection collection) {
        if (collection == null) {
            this.writeAttributes = null;
        } else {
            this.writeAttributes = new ArrayList(collection);
        }
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
        if (getClientName() != null) {
            sb.append("ClientName: " + getClientName() + ",");
        }
        if (getRefreshTokenValidity() != null) {
            sb.append("RefreshTokenValidity: " + getRefreshTokenValidity() + ",");
        }
        if (getAccessTokenValidity() != null) {
            sb.append("AccessTokenValidity: " + getAccessTokenValidity() + ",");
        }
        if (getIdTokenValidity() != null) {
            sb.append("IdTokenValidity: " + getIdTokenValidity() + ",");
        }
        if (getTokenValidityUnits() != null) {
            sb.append("TokenValidityUnits: " + getTokenValidityUnits() + ",");
        }
        if (getReadAttributes() != null) {
            sb.append("ReadAttributes: " + getReadAttributes() + ",");
        }
        if (getWriteAttributes() != null) {
            sb.append("WriteAttributes: " + getWriteAttributes() + ",");
        }
        if (getExplicitAuthFlows() != null) {
            sb.append("ExplicitAuthFlows: " + getExplicitAuthFlows() + ",");
        }
        if (getSupportedIdentityProviders() != null) {
            sb.append("SupportedIdentityProviders: " + getSupportedIdentityProviders() + ",");
        }
        if (getCallbackURLs() != null) {
            sb.append("CallbackURLs: " + getCallbackURLs() + ",");
        }
        if (getLogoutURLs() != null) {
            sb.append("LogoutURLs: " + getLogoutURLs() + ",");
        }
        if (getDefaultRedirectURI() != null) {
            sb.append("DefaultRedirectURI: " + getDefaultRedirectURI() + ",");
        }
        if (getAllowedOAuthFlows() != null) {
            sb.append("AllowedOAuthFlows: " + getAllowedOAuthFlows() + ",");
        }
        if (getAllowedOAuthScopes() != null) {
            sb.append("AllowedOAuthScopes: " + getAllowedOAuthScopes() + ",");
        }
        if (getAllowedOAuthFlowsUserPoolClient() != null) {
            sb.append("AllowedOAuthFlowsUserPoolClient: " + getAllowedOAuthFlowsUserPoolClient() + ",");
        }
        if (getAnalyticsConfiguration() != null) {
            sb.append("AnalyticsConfiguration: " + getAnalyticsConfiguration() + ",");
        }
        if (getPreventUserExistenceErrors() != null) {
            sb.append("PreventUserExistenceErrors: " + getPreventUserExistenceErrors() + ",");
        }
        if (getEnableTokenRevocation() != null) {
            sb.append("EnableTokenRevocation: " + getEnableTokenRevocation() + ",");
        }
        if (getEnablePropagateAdditionalUserContextData() != null) {
            sb.append("EnablePropagateAdditionalUserContextData: " + getEnablePropagateAdditionalUserContextData() + ",");
        }
        if (getAuthSessionValidity() != null) {
            sb.append("AuthSessionValidity: " + getAuthSessionValidity());
        }
        sb.append("}");
        return sb.toString();
    }

    public UpdateUserPoolClientRequest withAccessTokenValidity(Integer num) {
        this.accessTokenValidity = num;
        return this;
    }

    public UpdateUserPoolClientRequest withAllowedOAuthFlows(Collection collection) {
        setAllowedOAuthFlows(collection);
        return this;
    }

    public UpdateUserPoolClientRequest withAllowedOAuthFlowsUserPoolClient(Boolean bool) {
        this.allowedOAuthFlowsUserPoolClient = bool;
        return this;
    }

    public UpdateUserPoolClientRequest withAllowedOAuthScopes(Collection collection) {
        setAllowedOAuthScopes(collection);
        return this;
    }

    public UpdateUserPoolClientRequest withAnalyticsConfiguration(AnalyticsConfigurationType analyticsConfigurationType) {
        this.analyticsConfiguration = analyticsConfigurationType;
        return this;
    }

    public UpdateUserPoolClientRequest withAuthSessionValidity(Integer num) {
        this.authSessionValidity = num;
        return this;
    }

    public UpdateUserPoolClientRequest withCallbackURLs(Collection collection) {
        setCallbackURLs(collection);
        return this;
    }

    public UpdateUserPoolClientRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public UpdateUserPoolClientRequest withClientName(String str) {
        this.clientName = str;
        return this;
    }

    public UpdateUserPoolClientRequest withDefaultRedirectURI(String str) {
        this.defaultRedirectURI = str;
        return this;
    }

    public UpdateUserPoolClientRequest withEnablePropagateAdditionalUserContextData(Boolean bool) {
        this.enablePropagateAdditionalUserContextData = bool;
        return this;
    }

    public UpdateUserPoolClientRequest withEnableTokenRevocation(Boolean bool) {
        this.enableTokenRevocation = bool;
        return this;
    }

    public UpdateUserPoolClientRequest withExplicitAuthFlows(Collection collection) {
        setExplicitAuthFlows(collection);
        return this;
    }

    public UpdateUserPoolClientRequest withIdTokenValidity(Integer num) {
        this.idTokenValidity = num;
        return this;
    }

    public UpdateUserPoolClientRequest withLogoutURLs(Collection collection) {
        setLogoutURLs(collection);
        return this;
    }

    public UpdateUserPoolClientRequest withPreventUserExistenceErrors(PreventUserExistenceErrorTypes preventUserExistenceErrorTypes) {
        this.preventUserExistenceErrors = preventUserExistenceErrorTypes.toString();
        return this;
    }

    public UpdateUserPoolClientRequest withReadAttributes(Collection collection) {
        setReadAttributes(collection);
        return this;
    }

    public UpdateUserPoolClientRequest withRefreshTokenValidity(Integer num) {
        this.refreshTokenValidity = num;
        return this;
    }

    public UpdateUserPoolClientRequest withSupportedIdentityProviders(Collection collection) {
        setSupportedIdentityProviders(collection);
        return this;
    }

    public UpdateUserPoolClientRequest withTokenValidityUnits(TokenValidityUnitsType tokenValidityUnitsType) {
        this.tokenValidityUnits = tokenValidityUnitsType;
        return this;
    }

    public UpdateUserPoolClientRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public UpdateUserPoolClientRequest withWriteAttributes(Collection collection) {
        setWriteAttributes(collection);
        return this;
    }

    public void setPreventUserExistenceErrors(String str) {
        this.preventUserExistenceErrors = str;
    }

    public UpdateUserPoolClientRequest withAllowedOAuthFlows(String... strArr) {
        if (getAllowedOAuthFlows() == null) {
            this.allowedOAuthFlows = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.allowedOAuthFlows.add(str);
        }
        return this;
    }

    public UpdateUserPoolClientRequest withAllowedOAuthScopes(String... strArr) {
        if (getAllowedOAuthScopes() == null) {
            this.allowedOAuthScopes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.allowedOAuthScopes.add(str);
        }
        return this;
    }

    public UpdateUserPoolClientRequest withCallbackURLs(String... strArr) {
        if (getCallbackURLs() == null) {
            this.callbackURLs = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.callbackURLs.add(str);
        }
        return this;
    }

    public UpdateUserPoolClientRequest withExplicitAuthFlows(String... strArr) {
        if (getExplicitAuthFlows() == null) {
            this.explicitAuthFlows = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.explicitAuthFlows.add(str);
        }
        return this;
    }

    public UpdateUserPoolClientRequest withLogoutURLs(String... strArr) {
        if (getLogoutURLs() == null) {
            this.logoutURLs = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.logoutURLs.add(str);
        }
        return this;
    }

    public UpdateUserPoolClientRequest withPreventUserExistenceErrors(String str) {
        this.preventUserExistenceErrors = str;
        return this;
    }

    public UpdateUserPoolClientRequest withReadAttributes(String... strArr) {
        if (getReadAttributes() == null) {
            this.readAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.readAttributes.add(str);
        }
        return this;
    }

    public UpdateUserPoolClientRequest withSupportedIdentityProviders(String... strArr) {
        if (getSupportedIdentityProviders() == null) {
            this.supportedIdentityProviders = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.supportedIdentityProviders.add(str);
        }
        return this;
    }

    public UpdateUserPoolClientRequest withWriteAttributes(String... strArr) {
        if (getWriteAttributes() == null) {
            this.writeAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.writeAttributes.add(str);
        }
        return this;
    }
}
