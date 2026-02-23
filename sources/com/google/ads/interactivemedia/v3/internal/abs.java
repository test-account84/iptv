package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class abs {
    private final cj a = new cj(8);
    private int b;

    private final long b(zi ziVar) throws IOException {
        int i = 0;
        ziVar.f(this.a.H(), 0, 1);
        int i2 = this.a.H()[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        ziVar.f(this.a.H(), 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.a.H()[i] & 255) + (i5 << 8);
        }
        this.b += i4 + 1;
        return i5;
    }

    public final boolean a(zi ziVar) throws IOException {
        long b = ziVar.b();
        long j = 1024;
        if (b != -1 && b <= 1024) {
            j = b;
        }
        int i = (int) j;
        ziVar.f(this.a.H(), 0, 4);
        long p = this.a.p();
        this.b = 4;
        while (p != 440786851) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == i) {
                return false;
            }
            ziVar.f(this.a.H(), 0, 1);
            p = ((p << 8) & (-256)) | (this.a.H()[0] & 255);
        }
        long b2 = b(ziVar);
        long j2 = this.b;
        if (b2 != Long.MIN_VALUE && (b == -1 || j2 + b2 < b)) {
            while (true) {
                long j3 = this.b;
                long j4 = j2 + b2;
                if (j3 < j4) {
                    if (b(ziVar) == Long.MIN_VALUE) {
                        return false;
                    }
                    long b3 = b(ziVar);
                    if (b3 < 0) {
                        return false;
                    }
                    if (b3 != 0) {
                        int i3 = (int) b3;
                        ziVar.e(i3);
                        this.b += i3;
                    }
                } else if (j3 == j4) {
                    return true;
                }
            }
        }
        return false;
    }
}
