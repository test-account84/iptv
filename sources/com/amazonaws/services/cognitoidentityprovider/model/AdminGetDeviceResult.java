package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminGetDeviceResult implements Serializable {
    private DeviceType device;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminGetDeviceResult)) {
            return false;
        }
        AdminGetDeviceResult adminGetDeviceResult = (AdminGetDeviceResult) obj;
        if ((adminGetDeviceResult.getDevice() == null) ^ (getDevice() == null)) {
            return false;
        }
        return adminGetDeviceResult.getDevice() == null || adminGetDeviceResult.getDevice().equals(getDevice());
    }

    public DeviceType getDevice() {
        return this.device;
    }

    public int hashCode() {
        return 31 + (getDevice() == null ? 0 : getDevice().hashCode());
    }

    public void setDevice(DeviceType deviceType) {
        this.device = deviceType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDevice() != null) {
            sb.append("Device: " + getDevice());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminGetDeviceResult withDevice(DeviceType deviceType) {
        this.device = deviceType;
        return this;
    }
}
