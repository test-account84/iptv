package com.amazonaws.internal;

import com.amazonaws.AbortedException;
import com.amazonaws.logging.LogFactory;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class SdkInputStream extends InputStream implements MetricAware {
    public void abort() throws IOException {
    }

    public final void abortIfNeeded() {
        if (Thread.interrupted()) {
            try {
                abort();
            } catch (IOException e) {
                LogFactory.getLog(getClass()).debug("FYI", e);
            }
            throw new AbortedException();
        }
    }

    public abstract InputStream getWrappedInputStream();

    @Deprecated
    public final boolean isMetricActivated() {
        MetricAware wrappedInputStream = getWrappedInputStream();
        if (wrappedInputStream instanceof MetricAware) {
            return wrappedInputStream.isMetricActivated();
        }
        return false;
    }
}
