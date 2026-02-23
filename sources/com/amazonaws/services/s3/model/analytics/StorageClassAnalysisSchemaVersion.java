package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum StorageClassAnalysisSchemaVersion implements Serializable {
    V_1("V_1");

    private final String version;

    StorageClassAnalysisSchemaVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return this.version;
    }
}
