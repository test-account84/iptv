package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class EventContextDataType implements Serializable {
    private String city;
    private String country;
    private String deviceName;
    private String ipAddress;
    private String timezone;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EventContextDataType)) {
            return false;
        }
        EventContextDataType eventContextDataType = (EventContextDataType) obj;
        if ((eventContextDataType.getIpAddress() == null) ^ (getIpAddress() == null)) {
            return false;
        }
        if (eventContextDataType.getIpAddress() != null && !eventContextDataType.getIpAddress().equals(getIpAddress())) {
            return false;
        }
        if ((eventContextDataType.getDeviceName() == null) ^ (getDeviceName() == null)) {
            return false;
        }
        if (eventContextDataType.getDeviceName() != null && !eventContextDataType.getDeviceName().equals(getDeviceName())) {
            return false;
        }
        if ((eventContextDataType.getTimezone() == null) ^ (getTimezone() == null)) {
            return false;
        }
        if (eventContextDataType.getTimezone() != null && !eventContextDataType.getTimezone().equals(getTimezone())) {
            return false;
        }
        if ((eventContextDataType.getCity() == null) ^ (getCity() == null)) {
            return false;
        }
        if (eventContextDataType.getCity() != null && !eventContextDataType.getCity().equals(getCity())) {
            return false;
        }
        if ((eventContextDataType.getCountry() == null) ^ (getCountry() == null)) {
            return false;
        }
        return eventContextDataType.getCountry() == null || eventContextDataType.getCountry().equals(getCountry());
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public int hashCode() {
        return (((((((((getIpAddress() == null ? 0 : getIpAddress().hashCode()) + 31) * 31) + (getDeviceName() == null ? 0 : getDeviceName().hashCode())) * 31) + (getTimezone() == null ? 0 : getTimezone().hashCode())) * 31) + (getCity() == null ? 0 : getCity().hashCode())) * 31) + (getCountry() != null ? getCountry().hashCode() : 0);
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getIpAddress() != null) {
            sb.append("IpAddress: " + getIpAddress() + ",");
        }
        if (getDeviceName() != null) {
            sb.append("DeviceName: " + getDeviceName() + ",");
        }
        if (getTimezone() != null) {
            sb.append("Timezone: " + getTimezone() + ",");
        }
        if (getCity() != null) {
            sb.append("City: " + getCity() + ",");
        }
        if (getCountry() != null) {
            sb.append("Country: " + getCountry());
        }
        sb.append("}");
        return sb.toString();
    }

    public EventContextDataType withCity(String str) {
        this.city = str;
        return this;
    }

    public EventContextDataType withCountry(String str) {
        this.country = str;
        return this;
    }

    public EventContextDataType withDeviceName(String str) {
        this.deviceName = str;
        return this;
    }

    public EventContextDataType withIpAddress(String str) {
        this.ipAddress = str;
        return this;
    }

    public EventContextDataType withTimezone(String str) {
        this.timezone = str;
        return this;
    }
}
