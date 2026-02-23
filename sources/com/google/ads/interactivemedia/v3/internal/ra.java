package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ra {
    private long a;
    private long b;
    private boolean c;

    private final long d(long j) {
        return this.a + Math.max(0L, ((this.b - 529) * 1000000) / j);
    }

    public final long a(s sVar) {
        return d(sVar.z);
    }

    public final long b(s sVar, ef efVar) {
        if (this.b == 0) {
            this.a = efVar.d;
        }
        if (this.c) {
            return efVar.d;
        }
        ByteBuffer byteBuffer = efVar.b;
        af.s(byteBuffer);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i = (i << 8) | (byteBuffer.get(i2) & 255);
        }
        int c = zs.c(i);
        if (c != -1) {
            long d = d(sVar.z);
            this.b += c;
            return d;
        }
        this.c = true;
        this.b = 0L;
        this.a = efVar.d;
        cd.e("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
        return efVar.d;
    }

    public final void c() {
        this.a = 0L;
        this.b = 0L;
        this.c = false;
    }
}
