package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StorageClassAnalysisDataExport implements Serializable {
    private AnalyticsExportDestination destination;
    private String outputSchemaVersion;

    public AnalyticsExportDestination getDestination() {
        return this.destination;
    }

    public String getOutputSchemaVersion() {
        return this.outputSchemaVersion;
    }

    public void setDestination(AnalyticsExportDestination analyticsExportDestination) {
        this.destination = analyticsExportDestination;
    }

    public void setOutputSchemaVersion(StorageClassAnalysisSchemaVersion storageClassAnalysisSchemaVersion) {
        setOutputSchemaVersion(storageClassAnalysisSchemaVersion == null ? null : storageClassAnalysisSchemaVersion.toString());
    }

    public StorageClassAnalysisDataExport withDestination(AnalyticsExportDestination analyticsExportDestination) {
        setDestination(analyticsExportDestination);
        return this;
    }

    public StorageClassAnalysisDataExport withOutputSchemaVersion(StorageClassAnalysisSchemaVersion storageClassAnalysisSchemaVersion) {
        setOutputSchemaVersion(storageClassAnalysisSchemaVersion);
        return this;
    }

    public void setOutputSchemaVersion(String str) {
        this.outputSchemaVersion = str;
    }

    public StorageClassAnalysisDataExport withOutputSchemaVersion(String str) {
        setOutputSchemaVersion(str);
        return this;
    }
}
