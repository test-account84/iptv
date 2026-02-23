package com.amazonaws.internal;

import com.amazonaws.AbortedException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SdkFilterInputStream extends FilterInputStream implements MetricAware {
    public SdkFilterInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public void abort() {
    }

    public final void abortIfNeeded() {
        if (Thread.interrupted()) {
            abort();
            throw new AbortedException();
        }
    }

    public int available() throws IOException {
        abortIfNeeded();
        return ((FilterInputStream) this).in.available();
    }

    public void close() throws IOException {
        ((FilterInputStream) this).in.close();
        abortIfNeeded();
    }

    @Deprecated
    public boolean isMetricActivated() {
        if (((FilterInputStream) this).in instanceof MetricAware) {
            return ((FilterInputStream) this).in.isMetricActivated();
        }
        return false;
    }

    public synchronized void mark(int i) {
        abortIfNeeded();
        ((FilterInputStream) this).in.mark(i);
    }

    public boolean markSupported() {
        abortIfNeeded();
        return ((FilterInputStream) this).in.markSupported();
    }

    public int read() throws IOException {
        abortIfNeeded();
        return ((FilterInputStream) this).in.read();
    }

    public synchronized void reset() throws IOException {
        abortIfNeeded();
        ((FilterInputStream) this).in.reset();
    }

    public long skip(long j) throws IOException {
        abortIfNeeded();
        return ((FilterInputStream) this).in.skip(j);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        abortIfNeeded();
        return ((FilterInputStream) this).in.read(bArr, i, i2);
    }
}
