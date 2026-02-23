package io.antmedia.rtmp_client;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class RtmpClient {
    public long a = 0;
    public int b = 10000;
    public int c = 10000;

    public static class a extends IOException {
        public final int a;

        public a(int i) {
            super("RTMP error: " + i);
            this.a = i;
        }
    }

    static {
        System.loadLibrary("rtmp-jni");
    }

    private native long nativeAlloc();

    private native void nativeClose(long j);

    private native int nativeOpen(String str, boolean z, long j, int i, int i2);

    private native int nativeRead(byte[] bArr, int i, int i2, long j) throws IllegalStateException;

    public void a() {
        nativeClose(this.a);
        this.a = 0L;
    }

    public void b(String str, boolean z) {
        long nativeAlloc = nativeAlloc();
        this.a = nativeAlloc;
        if (nativeAlloc == 0) {
            throw new a(-2);
        }
        int nativeOpen = nativeOpen(str, z, nativeAlloc, this.b, this.c);
        if (nativeOpen == 0) {
            return;
        }
        this.a = 0L;
        throw new a(nativeOpen);
    }

    public int c(byte[] bArr, int i, int i2) {
        int nativeRead = nativeRead(bArr, i, i2, this.a);
        if (nativeRead >= 0 || nativeRead == -1) {
            return nativeRead;
        }
        throw new a(nativeRead);
    }
}
