package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aaf {
    private final byte[] a = new byte[10];
    private boolean b;
    private int c;
    private long d;
    private int e;
    private int f;
    private int g;

    public final void a(aae aaeVar, aad aadVar) {
        if (this.c > 0) {
            aaeVar.f(this.d, this.e, this.f, this.g, aadVar);
            this.c = 0;
        }
    }

    public final void b() {
        this.b = false;
        this.c = 0;
    }

    public final void c(aae aaeVar, long j, int i, int i2, int i3, aad aadVar) {
        af.x(this.g <= i2 + i3, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.b) {
            int i4 = this.c;
            int i5 = i4 + 1;
            this.c = i5;
            if (i4 == 0) {
                this.d = j;
                this.e = i;
                this.f = 0;
            }
            this.f += i2;
            this.g = i3;
            if (i5 >= 16) {
                a(aaeVar, aadVar);
            }
        }
    }

    public final void d(zi ziVar) throws IOException {
        if (this.b) {
            return;
        }
        ziVar.f(this.a, 0, 10);
        ziVar.h();
        byte[] bArr = this.a;
        int i = yo.a;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            this.b = true;
        }
    }
}
