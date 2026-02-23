package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AnalyticsConfigurationType implements Serializable {
    private String applicationArn;
    private String applicationId;
    private String externalId;
    private String roleArn;
    private Boolean userDataShared;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AnalyticsConfigurationType)) {
            return false;
        }
        AnalyticsConfigurationType analyticsConfigurationType = (AnalyticsConfigurationType) obj;
        if ((analyticsConfigurationType.getApplicationId() == null) ^ (getApplicationId() == null)) {
            return false;
        }
        if (analyticsConfigurationType.getApplicationId() != null && !analyticsConfigurationType.getApplicationId().equals(getApplicationId())) {
            return false;
        }
        if ((analyticsConfigurationType.getApplicationArn() == null) ^ (getApplicationArn() == null)) {
            return false;
        }
        if (analyticsConfigurationType.getApplicationArn() != null && !analyticsConfigurationType.getApplicationArn().equals(getApplicationArn())) {
            return false;
        }
        if ((analyticsConfigurationType.getRoleArn() == null) ^ (getRoleArn() == null)) {
            return false;
        }
        if (analyticsConfigurationType.getRoleArn() != null && !analyticsConfigurationType.getRoleArn().equals(getRoleArn())) {
            return false;
        }
        if ((analyticsConfigurationType.getExternalId() == null) ^ (getExternalId() == null)) {
            return false;
        }
        if (analyticsConfigurationType.getExternalId() != null && !analyticsConfigurationType.getExternalId().equals(getExternalId())) {
            return false;
        }
        if ((analyticsConfigurationType.getUserDataShared() == null) ^ (getUserDataShared() == null)) {
            return false;
        }
        return analyticsConfigurationType.getUserDataShared() == null || analyticsConfigurationType.getUserDataShared().equals(getUserDataShared());
    }

    public String getApplicationArn() {
        return this.applicationArn;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public String getRoleArn() {
        return this.roleArn;
    }

    public Boolean getUserDataShared() {
        return this.userDataShared;
    }

    public int hashCode() {
        return (((((((((getApplicationId() == null ? 0 : getApplicationId().hashCode()) + 31) * 31) + (getApplicationArn() == null ? 0 : getApplicationArn().hashCode())) * 31) + (getRoleArn() == null ? 0 : getRoleArn().hashCode())) * 31) + (getExternalId() == null ? 0 : getExternalId().hashCode())) * 31) + (getUserDataShared() != null ? getUserDataShared().hashCode() : 0);
    }

    public Boolean isUserDataShared() {
        return this.userDataShared;
    }

    public void setApplicationArn(String str) {
        this.applicationArn = str;
    }

    public void setApplicationId(String str) {
        this.applicationId = str;
    }

    public void setExternalId(String str) {
        this.externalId = str;
    }

    public void setRoleArn(String str) {
        this.roleArn = str;
    }

    public void setUserDataShared(Boolean bool) {
        this.userDataShared = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getApplicationId() != null) {
            sb.append("ApplicationId: " + getApplicationId() + ",");
        }
        if (getApplicationArn() != null) {
            sb.append("ApplicationArn: " + getApplicationArn() + ",");
        }
        if (getRoleArn() != null) {
            sb.append("RoleArn: " + getRoleArn() + ",");
        }
        if (getExternalId() != null) {
            sb.append("ExternalId: " + getExternalId() + ",");
        }
        if (getUserDataShared() != null) {
            sb.append("UserDataShared: " + getUserDataShared());
        }
        sb.append("}");
        return sb.toString();
    }

    public AnalyticsConfigurationType withApplicationArn(String str) {
        this.applicationArn = str;
        return this;
    }

    public AnalyticsConfigurationType withApplicationId(String str) {
        this.applicationId = str;
        return this;
    }

    public AnalyticsConfigurationType withExternalId(String str) {
        this.externalId = str;
        return this;
    }

    public AnalyticsConfigurationType withRoleArn(String str) {
        this.roleArn = str;
        return this;
    }

    public AnalyticsConfigurationType withUserDataShared(Boolean bool) {
        this.userDataShared = bool;
        return this;
    }
}
