package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class adv {
    private final aae a;
    private boolean b;
    private boolean c;
    private boolean d;
    private int e;
    private int f;
    private long g;
    private long h;

    public adv(aae aaeVar) {
        this.a = aaeVar;
    }

    public final void a(byte[] bArr, int i, int i2) {
        if (this.c) {
            int i3 = this.f;
            int i4 = (i + 1) - i3;
            if (i4 >= i2) {
                this.f = i3 + (i2 - i);
            } else {
                this.d = ((bArr[i4] & 192) >> 6) == 0;
                this.c = false;
            }
        }
    }

    public final void b(long j, int i, boolean z) {
        if (this.e == 182 && z && this.b) {
            long j2 = this.h;
            if (j2 != -9223372036854775807L) {
                long j3 = this.g;
                this.a.f(j2, this.d ? 1 : 0, (int) (j - j3), i, null);
            }
        }
        if (this.e != 179) {
            this.g = j;
        }
    }

    public final void c(int i, long j) {
        boolean z;
        this.e = i;
        this.d = false;
        if (i == 182) {
            z = true;
        } else if (i == 179) {
            i = 179;
            z = true;
        } else {
            z = false;
        }
        this.b = z;
        this.c = i == 182;
        this.f = 0;
        this.h = j;
    }

    public final void d() {
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = -1;
    }
}
