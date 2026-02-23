package com.amplifyframework.auth;

import O.c;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AuthDevice {
    private final String deviceId;
    private final String deviceName;

    private AuthDevice(String str, String str2) {
        this.deviceId = str;
        this.deviceName = str2;
    }

    public static AuthDevice fromId(String str) {
        return fromId(str, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthDevice.class != obj.getClass()) {
            return false;
        }
        AuthDevice authDevice = (AuthDevice) obj;
        return c.a(getDeviceId(), authDevice.getDeviceId()) && c.a(getDeviceName(), authDevice.getDeviceName());
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int hashCode() {
        return c.b(getDeviceId(), getDeviceName());
    }

    public String toString() {
        return "AuthDevice{deviceId='" + this.deviceId + "', deviceName='" + this.deviceName + "'}";
    }

    public static AuthDevice fromId(String str, String str2) {
        Objects.requireNonNull(str);
        return new AuthDevice(str, str2);
    }
}
