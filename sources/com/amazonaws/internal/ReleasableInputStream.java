package com.amazonaws.internal;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ReleasableInputStream extends SdkFilterInputStream implements Releasable {
    private static final Log log = LogFactory.getLog(ReleasableInputStream.class);
    private boolean closeDisabled;

    public ReleasableInputStream(InputStream inputStream) {
        super(inputStream);
    }

    private void doRelease() {
        try {
            ((FilterInputStream) this).in.close();
        } catch (Exception e) {
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug("FYI", e);
            }
        }
        if (((FilterInputStream) this).in instanceof Releasable) {
            ((FilterInputStream) this).in.release();
        }
        abortIfNeeded();
    }

    public static ReleasableInputStream wrap(InputStream inputStream) {
        return inputStream instanceof ReleasableInputStream ? (ReleasableInputStream) inputStream : inputStream instanceof FileInputStream ? ResettableInputStream.newResettableInputStream((FileInputStream) inputStream) : new ReleasableInputStream(inputStream);
    }

    public final void close() {
        if (this.closeDisabled) {
            return;
        }
        doRelease();
    }

    public final ReleasableInputStream disableClose() {
        this.closeDisabled = true;
        return this;
    }

    public final boolean isCloseDisabled() {
        return this.closeDisabled;
    }

    public final void release() {
        doRelease();
    }
}
