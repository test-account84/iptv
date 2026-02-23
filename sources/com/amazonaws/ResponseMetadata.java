package com.amazonaws;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ResponseMetadata {
    public static final String AWS_REQUEST_ID = "AWS_REQUEST_ID";
    protected final Map metadata;

    public ResponseMetadata(ResponseMetadata responseMetadata) {
        this(responseMetadata.metadata);
    }

    public String getRequestId() {
        return (String) this.metadata.get("AWS_REQUEST_ID");
    }

    public String toString() {
        Map map = this.metadata;
        return map == null ? "{}" : map.toString();
    }

    public ResponseMetadata(Map map) {
        this.metadata = map;
    }
}
