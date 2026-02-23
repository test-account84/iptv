package org.apache.http.impl.io;

import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class EmptyInputStream extends InputStream {
    public static final EmptyInputStream INSTANCE = new EmptyInputStream();

    private EmptyInputStream() {
    }

    public int available() {
        return 0;
    }

    public void close() {
    }

    public void mark(int i) {
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        return -1;
    }

    public void reset() {
    }

    public long skip(long j) {
        return 0L;
    }

    public int read(byte[] bArr) {
        return -1;
    }

    public int read(byte[] bArr, int i, int i2) {
        return -1;
    }
}
