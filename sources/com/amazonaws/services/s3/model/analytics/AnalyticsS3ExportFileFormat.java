package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum AnalyticsS3ExportFileFormat implements Serializable {
    CSV("CSV");

    private final String format;

    AnalyticsS3ExportFileFormat(String str) {
        this.format = str;
    }

    public String toString() {
        return this.format;
    }
}
