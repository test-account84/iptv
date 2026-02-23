package com.amazonaws.metrics;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MetricFilterInputStream extends SdkFilterInputStream {
    private final ByteThroughputHelper helper;

    public MetricFilterInputStream(ThroughputMetricType throughputMetricType, InputStream inputStream) {
        super(inputStream);
        this.helper = new ByteThroughputHelper(throughputMetricType);
    }

    public void close() throws IOException {
        this.helper.reportMetrics();
        ((FilterInputStream) this).in.close();
        abortIfNeeded();
    }

    public final boolean isMetricActivated() {
        return true;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        abortIfNeeded();
        long startTiming = this.helper.startTiming();
        int read = ((FilterInputStream) this).in.read(bArr, i, i2);
        if (read > 0) {
            this.helper.increment(read, startTiming);
        }
        return read;
    }
}
