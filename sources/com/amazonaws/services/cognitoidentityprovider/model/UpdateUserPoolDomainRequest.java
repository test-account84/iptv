package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UpdateUserPoolDomainRequest extends AmazonWebServiceRequest implements Serializable {
    private CustomDomainConfigType customDomainConfig;
    private String domain;
    private String userPoolId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateUserPoolDomainRequest)) {
            return false;
        }
        UpdateUserPoolDomainRequest updateUserPoolDomainRequest = (UpdateUserPoolDomainRequest) obj;
        if ((updateUserPoolDomainRequest.getDomain() == null) ^ (getDomain() == null)) {
            return false;
        }
        if (updateUserPoolDomainRequest.getDomain() != null && !updateUserPoolDomainRequest.getDomain().equals(getDomain())) {
            return false;
        }
        if ((updateUserPoolDomainRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (updateUserPoolDomainRequest.getUserPoolId() != null && !updateUserPoolDomainRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((updateUserPoolDomainRequest.getCustomDomainConfig() == null) ^ (getCustomDomainConfig() == null)) {
            return false;
        }
        return updateUserPoolDomainRequest.getCustomDomainConfig() == null || updateUserPoolDomainRequest.getCustomDomainConfig().equals(getCustomDomainConfig());
    }

    public CustomDomainConfigType getCustomDomainConfig() {
        return this.customDomainConfig;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        return (((((getDomain() == null ? 0 : getDomain().hashCode()) + 31) * 31) + (getUserPoolId() == null ? 0 : getUserPoolId().hashCode())) * 31) + (getCustomDomainConfig() != null ? getCustomDomainConfig().hashCode() : 0);
    }

    public void setCustomDomainConfig(CustomDomainConfigType customDomainConfigType) {
        this.customDomainConfig = customDomainConfigType;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDomain() != null) {
            sb.append("Domain: " + getDomain() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getCustomDomainConfig() != null) {
            sb.append("CustomDomainConfig: " + getCustomDomainConfig());
        }
        sb.append("}");
        return sb.toString();
    }

    public UpdateUserPoolDomainRequest withCustomDomainConfig(CustomDomainConfigType customDomainConfigType) {
        this.customDomainConfig = customDomainConfigType;
        return this;
    }

    public UpdateUserPoolDomainRequest withDomain(String str) {
        this.domain = str;
        return this;
    }

    public UpdateUserPoolDomainRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
