package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class RiskConfigurationType implements Serializable {
    private AccountTakeoverRiskConfigurationType accountTakeoverRiskConfiguration;
    private String clientId;
    private CompromisedCredentialsRiskConfigurationType compromisedCredentialsRiskConfiguration;
    private Date lastModifiedDate;
    private RiskExceptionConfigurationType riskExceptionConfiguration;
    private String userPoolId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RiskConfigurationType)) {
            return false;
        }
        RiskConfigurationType riskConfigurationType = (RiskConfigurationType) obj;
        if ((riskConfigurationType.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (riskConfigurationType.getUserPoolId() != null && !riskConfigurationType.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((riskConfigurationType.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (riskConfigurationType.getClientId() != null && !riskConfigurationType.getClientId().equals(getClientId())) {
            return false;
        }
        if ((riskConfigurationType.getCompromisedCredentialsRiskConfiguration() == null) ^ (getCompromisedCredentialsRiskConfiguration() == null)) {
            return false;
        }
        if (riskConfigurationType.getCompromisedCredentialsRiskConfiguration() != null && !riskConfigurationType.getCompromisedCredentialsRiskConfiguration().equals(getCompromisedCredentialsRiskConfiguration())) {
            return false;
        }
        if ((riskConfigurationType.getAccountTakeoverRiskConfiguration() == null) ^ (getAccountTakeoverRiskConfiguration() == null)) {
            return false;
        }
        if (riskConfigurationType.getAccountTakeoverRiskConfiguration() != null && !riskConfigurationType.getAccountTakeoverRiskConfiguration().equals(getAccountTakeoverRiskConfiguration())) {
            return false;
        }
        if ((riskConfigurationType.getRiskExceptionConfiguration() == null) ^ (getRiskExceptionConfiguration() == null)) {
            return false;
        }
        if (riskConfigurationType.getRiskExceptionConfiguration() != null && !riskConfigurationType.getRiskExceptionConfiguration().equals(getRiskExceptionConfiguration())) {
            return false;
        }
        if ((riskConfigurationType.getLastModifiedDate() == null) ^ (getLastModifiedDate() == null)) {
            return false;
        }
        return riskConfigurationType.getLastModifiedDate() == null || riskConfigurationType.getLastModifiedDate().equals(getLastModifiedDate());
    }

    public AccountTakeoverRiskConfigurationType getAccountTakeoverRiskConfiguration() {
        return this.accountTakeoverRiskConfiguration;
    }

    public String getClientId() {
        return this.clientId;
    }

    public CompromisedCredentialsRiskConfigurationType getCompromisedCredentialsRiskConfiguration() {
        return this.compromisedCredentialsRiskConfiguration;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public RiskExceptionConfigurationType getRiskExceptionConfiguration() {
        return this.riskExceptionConfiguration;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        return (((((((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getClientId() == null ? 0 : getClientId().hashCode())) * 31) + (getCompromisedCredentialsRiskConfiguration() == null ? 0 : getCompromisedCredentialsRiskConfiguration().hashCode())) * 31) + (getAccountTakeoverRiskConfiguration() == null ? 0 : getAccountTakeoverRiskConfiguration().hashCode())) * 31) + (getRiskExceptionConfiguration() == null ? 0 : getRiskExceptionConfiguration().hashCode())) * 31) + (getLastModifiedDate() != null ? getLastModifiedDate().hashCode() : 0);
    }

    public void setAccountTakeoverRiskConfiguration(AccountTakeoverRiskConfigurationType accountTakeoverRiskConfigurationType) {
        this.accountTakeoverRiskConfiguration = accountTakeoverRiskConfigurationType;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setCompromisedCredentialsRiskConfiguration(CompromisedCredentialsRiskConfigurationType compromisedCredentialsRiskConfigurationType) {
        this.compromisedCredentialsRiskConfiguration = compromisedCredentialsRiskConfigurationType;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public void setRiskExceptionConfiguration(RiskExceptionConfigurationType riskExceptionConfigurationType) {
        this.riskExceptionConfiguration = riskExceptionConfigurationType;
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
        if (getCompromisedCredentialsRiskConfiguration() != null) {
            sb.append("CompromisedCredentialsRiskConfiguration: " + getCompromisedCredentialsRiskConfiguration() + ",");
        }
        if (getAccountTakeoverRiskConfiguration() != null) {
            sb.append("AccountTakeoverRiskConfiguration: " + getAccountTakeoverRiskConfiguration() + ",");
        }
        if (getRiskExceptionConfiguration() != null) {
            sb.append("RiskExceptionConfiguration: " + getRiskExceptionConfiguration() + ",");
        }
        if (getLastModifiedDate() != null) {
            sb.append("LastModifiedDate: " + getLastModifiedDate());
        }
        sb.append("}");
        return sb.toString();
    }

    public RiskConfigurationType withAccountTakeoverRiskConfiguration(AccountTakeoverRiskConfigurationType accountTakeoverRiskConfigurationType) {
        this.accountTakeoverRiskConfiguration = accountTakeoverRiskConfigurationType;
        return this;
    }

    public RiskConfigurationType withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public RiskConfigurationType withCompromisedCredentialsRiskConfiguration(CompromisedCredentialsRiskConfigurationType compromisedCredentialsRiskConfigurationType) {
        this.compromisedCredentialsRiskConfiguration = compromisedCredentialsRiskConfigurationType;
        return this;
    }

    public RiskConfigurationType withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public RiskConfigurationType withRiskExceptionConfiguration(RiskExceptionConfigurationType riskExceptionConfigurationType) {
        this.riskExceptionConfiguration = riskExceptionConfigurationType;
        return this;
    }

    public RiskConfigurationType withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
