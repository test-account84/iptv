package com.amazonaws.mobile.client.results;

import java.util.Date;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class Device {
    private final Map attributes;
    private final Date createDate;
    private final String deviceKey;
    private final Date lastAuthenticatedDate;
    private final Date lastModifiedDate;

    public Device(String str, Map map, Date date, Date date2, Date date3) {
        this.deviceKey = str;
        this.attributes = map;
        this.createDate = date;
        this.lastModifiedDate = date2;
        this.lastAuthenticatedDate = date3;
    }

    public Map getAttributes() {
        return this.attributes;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public String getDeviceKey() {
        return this.deviceKey;
    }

    public Date getLastAuthenticatedDate() {
        return this.lastAuthenticatedDate;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }
}
