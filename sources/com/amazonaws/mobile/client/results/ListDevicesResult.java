package com.amazonaws.mobile.client.results;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListDevicesResult {
    private List devices;
    private String paginationToken;

    public ListDevicesResult(List list, String str) {
        this.devices = list;
        this.paginationToken = str;
    }

    public List getDevices() {
        return this.devices;
    }

    public String getPaginationToken() {
        return this.paginationToken;
    }
}
