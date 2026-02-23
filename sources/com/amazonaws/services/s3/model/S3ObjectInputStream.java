package com.amazonaws.services.s3.model;

import com.amazonaws.internal.MetricAware;
import com.amazonaws.internal.SdkFilterInputStream;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.MetricFilterInputStream;
import com.amazonaws.services.s3.metrics.S3ServiceMetric;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class S3ObjectInputStream extends SdkFilterInputStream {
    private boolean eof;

    public S3ObjectInputStream(InputStream inputStream) {
        super(wrapWithByteCounting(inputStream) ? new MetricFilterInputStream(S3ServiceMetric.S3_DOWLOAD_THROUGHPUT, inputStream) : inputStream);
    }

    private void doAbort() {
        try {
            close();
        } catch (IOException e) {
            LogFactory.getLog(getClass()).debug("FYI", e);
        }
    }

    private static boolean wrapWithByteCounting(InputStream inputStream) {
        if (!AwsSdkMetrics.isMetricsEnabled()) {
            return false;
        }
        if (inputStream instanceof MetricAware) {
            return !((MetricAware) inputStream).isMetricActivated();
        }
        return true;
    }

    public void abort() {
        doAbort();
    }

    public int available() throws IOException {
        int available = super.available();
        if (available == 0) {
            return 1;
        }
        return available;
    }

    public int read() throws IOException {
        int read = super.read();
        if (read == -1) {
            this.eof = true;
        }
        return read;
    }

    public void reset() throws IOException {
        super.reset();
        this.eof = false;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read == -1) {
            this.eof = true;
        }
        return read;
    }
}
