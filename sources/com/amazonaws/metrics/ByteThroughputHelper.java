package com.amazonaws.metrics;

import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class ByteThroughputHelper extends ByteThroughputProvider {
    private static final int REPORT_INTERVAL_SECS = 10;

    public ByteThroughputHelper(ThroughputMetricType throughputMetricType) {
        super(throughputMetricType);
    }

    public void increment(int i, long j) {
        super.increment(i, j);
    }

    public void reportMetrics() {
        if (getByteCount() > 0) {
            AwsSdkMetrics.getServiceMetricCollector().collectByteThroughput(this);
            reset();
        }
    }

    public long startTiming() {
        if (TimeUnit.NANOSECONDS.toSeconds(getDurationNano()) > 10) {
            reportMetrics();
        }
        return System.nanoTime();
    }
}
