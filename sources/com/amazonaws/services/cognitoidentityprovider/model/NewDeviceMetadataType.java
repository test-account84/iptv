package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class NewDeviceMetadataType implements Serializable {
    private String deviceGroupKey;
    private String deviceKey;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NewDeviceMetadataType)) {
            return false;
        }
        NewDeviceMetadataType newDeviceMetadataType = (NewDeviceMetadataType) obj;
        if ((newDeviceMetadataType.getDeviceKey() == null) ^ (getDeviceKey() == null)) {
            return false;
        }
        if (newDeviceMetadataType.getDeviceKey() != null && !newDeviceMetadataType.getDeviceKey().equals(getDeviceKey())) {
            return false;
        }
        if ((newDeviceMetadataType.getDeviceGroupKey() == null) ^ (getDeviceGroupKey() == null)) {
            return false;
        }
        return newDeviceMetadataType.getDeviceGroupKey() == null || newDeviceMetadataType.getDeviceGroupKey().equals(getDeviceGroupKey());
    }

    public String getDeviceGroupKey() {
        return this.deviceGroupKey;
    }

    public String getDeviceKey() {
        return this.deviceKey;
    }

    public int hashCode() {
        return (((getDeviceKey() == null ? 0 : getDeviceKey().hashCode()) + 31) * 31) + (getDeviceGroupKey() != null ? getDeviceGroupKey().hashCode() : 0);
    }

    public void setDeviceGroupKey(String str) {
        this.deviceGroupKey = str;
    }

    public void setDeviceKey(String str) {
        this.deviceKey = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDeviceKey() != null) {
            sb.append("DeviceKey: " + getDeviceKey() + ",");
        }
        if (getDeviceGroupKey() != null) {
            sb.append("DeviceGroupKey: " + getDeviceGroupKey());
        }
        sb.append("}");
        return sb.toString();
    }

    public NewDeviceMetadataType withDeviceGroupKey(String str) {
        this.deviceGroupKey = str;
        return this;
    }

    public NewDeviceMetadataType withDeviceKey(String str) {
        this.deviceKey = str;
        return this;
    }
}
