package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DeviceConfigurationType implements Serializable {
    private Boolean challengeRequiredOnNewDevice;
    private Boolean deviceOnlyRememberedOnUserPrompt;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeviceConfigurationType)) {
            return false;
        }
        DeviceConfigurationType deviceConfigurationType = (DeviceConfigurationType) obj;
        if ((deviceConfigurationType.getChallengeRequiredOnNewDevice() == null) ^ (getChallengeRequiredOnNewDevice() == null)) {
            return false;
        }
        if (deviceConfigurationType.getChallengeRequiredOnNewDevice() != null && !deviceConfigurationType.getChallengeRequiredOnNewDevice().equals(getChallengeRequiredOnNewDevice())) {
            return false;
        }
        if ((deviceConfigurationType.getDeviceOnlyRememberedOnUserPrompt() == null) ^ (getDeviceOnlyRememberedOnUserPrompt() == null)) {
            return false;
        }
        return deviceConfigurationType.getDeviceOnlyRememberedOnUserPrompt() == null || deviceConfigurationType.getDeviceOnlyRememberedOnUserPrompt().equals(getDeviceOnlyRememberedOnUserPrompt());
    }

    public Boolean getChallengeRequiredOnNewDevice() {
        return this.challengeRequiredOnNewDevice;
    }

    public Boolean getDeviceOnlyRememberedOnUserPrompt() {
        return this.deviceOnlyRememberedOnUserPrompt;
    }

    public int hashCode() {
        return (((getChallengeRequiredOnNewDevice() == null ? 0 : getChallengeRequiredOnNewDevice().hashCode()) + 31) * 31) + (getDeviceOnlyRememberedOnUserPrompt() != null ? getDeviceOnlyRememberedOnUserPrompt().hashCode() : 0);
    }

    public Boolean isChallengeRequiredOnNewDevice() {
        return this.challengeRequiredOnNewDevice;
    }

    public Boolean isDeviceOnlyRememberedOnUserPrompt() {
        return this.deviceOnlyRememberedOnUserPrompt;
    }

    public void setChallengeRequiredOnNewDevice(Boolean bool) {
        this.challengeRequiredOnNewDevice = bool;
    }

    public void setDeviceOnlyRememberedOnUserPrompt(Boolean bool) {
        this.deviceOnlyRememberedOnUserPrompt = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getChallengeRequiredOnNewDevice() != null) {
            sb.append("ChallengeRequiredOnNewDevice: " + getChallengeRequiredOnNewDevice() + ",");
        }
        if (getDeviceOnlyRememberedOnUserPrompt() != null) {
            sb.append("DeviceOnlyRememberedOnUserPrompt: " + getDeviceOnlyRememberedOnUserPrompt());
        }
        sb.append("}");
        return sb.toString();
    }

    public DeviceConfigurationType withChallengeRequiredOnNewDevice(Boolean bool) {
        this.challengeRequiredOnNewDevice = bool;
        return this;
    }

    public DeviceConfigurationType withDeviceOnlyRememberedOnUserPrompt(Boolean bool) {
        this.deviceOnlyRememberedOnUserPrompt = bool;
        return this;
    }
}
