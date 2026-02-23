package com.amazonaws.internal;

import java.io.FilterOutputStream;
import java.io.OutputStream;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SdkFilterOutputStream extends FilterOutputStream implements MetricAware {
    public SdkFilterOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public boolean isMetricActivated() {
        MetricAware metricAware = ((FilterOutputStream) this).out;
        if (metricAware instanceof MetricAware) {
            return metricAware.isMetricActivated();
        }
        return false;
    }
}
