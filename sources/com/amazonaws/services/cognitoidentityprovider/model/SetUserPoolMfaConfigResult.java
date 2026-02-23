package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SetUserPoolMfaConfigResult implements Serializable {
    private String mfaConfiguration;
    private SmsMfaConfigType smsMfaConfiguration;
    private SoftwareTokenMfaConfigType softwareTokenMfaConfiguration;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetUserPoolMfaConfigResult)) {
            return false;
        }
        SetUserPoolMfaConfigResult setUserPoolMfaConfigResult = (SetUserPoolMfaConfigResult) obj;
        if ((setUserPoolMfaConfigResult.getSmsMfaConfiguration() == null) ^ (getSmsMfaConfiguration() == null)) {
            return false;
        }
        if (setUserPoolMfaConfigResult.getSmsMfaConfiguration() != null && !setUserPoolMfaConfigResult.getSmsMfaConfiguration().equals(getSmsMfaConfiguration())) {
            return false;
        }
        if ((setUserPoolMfaConfigResult.getSoftwareTokenMfaConfiguration() == null) ^ (getSoftwareTokenMfaConfiguration() == null)) {
            return false;
        }
        if (setUserPoolMfaConfigResult.getSoftwareTokenMfaConfiguration() != null && !setUserPoolMfaConfigResult.getSoftwareTokenMfaConfiguration().equals(getSoftwareTokenMfaConfiguration())) {
            return false;
        }
        if ((setUserPoolMfaConfigResult.getMfaConfiguration() == null) ^ (getMfaConfiguration() == null)) {
            return false;
        }
        return setUserPoolMfaConfigResult.getMfaConfiguration() == null || setUserPoolMfaConfigResult.getMfaConfiguration().equals(getMfaConfiguration());
    }

    public String getMfaConfiguration() {
        return this.mfaConfiguration;
    }

    public SmsMfaConfigType getSmsMfaConfiguration() {
        return this.smsMfaConfiguration;
    }

    public SoftwareTokenMfaConfigType getSoftwareTokenMfaConfiguration() {
        return this.softwareTokenMfaConfiguration;
    }

    public int hashCode() {
        return (((((getSmsMfaConfiguration() == null ? 0 : getSmsMfaConfiguration().hashCode()) + 31) * 31) + (getSoftwareTokenMfaConfiguration() == null ? 0 : getSoftwareTokenMfaConfiguration().hashCode())) * 31) + (getMfaConfiguration() != null ? getMfaConfiguration().hashCode() : 0);
    }

    public void setMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
    }

    public void setSmsMfaConfiguration(SmsMfaConfigType smsMfaConfigType) {
        this.smsMfaConfiguration = smsMfaConfigType;
    }

    public void setSoftwareTokenMfaConfiguration(SoftwareTokenMfaConfigType softwareTokenMfaConfigType) {
        this.softwareTokenMfaConfiguration = softwareTokenMfaConfigType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSmsMfaConfiguration() != null) {
            sb.append("SmsMfaConfiguration: " + getSmsMfaConfiguration() + ",");
        }
        if (getSoftwareTokenMfaConfiguration() != null) {
            sb.append("SoftwareTokenMfaConfiguration: " + getSoftwareTokenMfaConfiguration() + ",");
        }
        if (getMfaConfiguration() != null) {
            sb.append("MfaConfiguration: " + getMfaConfiguration());
        }
        sb.append("}");
        return sb.toString();
    }

    public SetUserPoolMfaConfigResult withMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
        return this;
    }

    public SetUserPoolMfaConfigResult withSmsMfaConfiguration(SmsMfaConfigType smsMfaConfigType) {
        this.smsMfaConfiguration = smsMfaConfigType;
        return this;
    }

    public SetUserPoolMfaConfigResult withSoftwareTokenMfaConfiguration(SoftwareTokenMfaConfigType softwareTokenMfaConfigType) {
        this.softwareTokenMfaConfiguration = softwareTokenMfaConfigType;
        return this;
    }

    public void setMfaConfiguration(String str) {
        this.mfaConfiguration = str;
    }

    public SetUserPoolMfaConfigResult withMfaConfiguration(String str) {
        this.mfaConfiguration = str;
        return this;
    }
}
