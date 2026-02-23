package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class abt {
    private static final long[] a = {128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] b = new byte[8];
    private int c;
    private int d;

    public static int b(int i) {
        int i2 = 0;
        while (i2 < 8) {
            long j = a[i2] & i;
            i2++;
            if (j != 0) {
                return i2;
            }
        }
        return -1;
    }

    public static long c(byte[] bArr, int i, boolean z) {
        long j = bArr[0] & 255;
        if (z) {
            j &= ~a[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (bArr[i2] & 255);
        }
        return j;
    }

    public final int a() {
        return this.d;
    }

    public final long d(zi ziVar, boolean z, boolean z2, int i) throws IOException {
        if (this.c == 0) {
            if (!ziVar.l(this.b, 0, 1, z)) {
                return -1L;
            }
            int b = b(this.b[0] & 255);
            this.d = b;
            if (b == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.c = 1;
        }
        int i2 = this.d;
        if (i2 > i) {
            this.c = 0;
            return -2L;
        }
        if (i2 != 1) {
            ziVar.g(this.b, 1, i2 - 1);
        }
        this.c = 0;
        return c(this.b, this.d, z2);
    }

    public final void e() {
        this.c = 0;
        this.d = 0;
    }
}
