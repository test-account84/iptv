package com.google.ads.interactivemedia.v3.internal;

import android.util.SparseArray;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ady {
    private final aae a;
    private final boolean b;
    private final boolean c;
    private final zx f;
    private byte[] g;
    private int h;
    private int i;
    private long j;
    private boolean k;
    private long l;
    private boolean o;
    private long p;
    private long q;
    private boolean r;
    private final SparseArray d = new SparseArray();
    private final SparseArray e = new SparseArray();
    private adx m = new adx(null);
    private adx n = new adx(null);

    public ady(aae aaeVar, boolean z, boolean z2) {
        this.a = aaeVar;
        this.b = z;
        this.c = z2;
        byte[] bArr = new byte[128];
        this.g = bArr;
        this.f = new zx(bArr, 0, 0);
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(byte[] r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ady.a(byte[], int, int):void");
    }

    public final void b(zu zuVar) {
        this.e.append(zuVar.a, zuVar);
    }

    public final void c(zv zvVar) {
        this.d.append(zvVar.d, zvVar);
    }

    public final void d() {
        this.k = false;
        this.o = false;
        this.n.a();
    }

    public final void e(long j, int i, long j2) {
        this.i = i;
        this.l = j2;
        this.j = j;
        if (!this.b || i != 1) {
            if (!this.c) {
                return;
            }
            if (i != 5 && i != 1 && i != 2) {
                return;
            }
        }
        adx adxVar = this.m;
        this.m = this.n;
        this.n = adxVar;
        adxVar.a();
        this.h = 0;
        this.k = true;
    }

    public final boolean f(long j, int i, boolean z, boolean z2) {
        boolean z3 = false;
        if (this.i == 9 || (this.c && adx.d(this.n, this.m))) {
            if (z && this.o) {
                long j2 = this.j;
                int i2 = i + ((int) (j - j2));
                long j3 = this.q;
                if (j3 != -9223372036854775807L) {
                    this.a.f(j3, this.r ? 1 : 0, (int) (j2 - this.p), i2, null);
                }
            }
            this.p = this.j;
            this.q = this.l;
            this.r = false;
            this.o = true;
        }
        boolean e = this.b ? this.n.e() : z2;
        boolean z4 = this.r;
        int i3 = this.i;
        if (i3 == 5 || (e && i3 == 1)) {
            z3 = true;
        }
        boolean z5 = z4 | z3;
        this.r = z5;
        return z5;
    }

    public final boolean g() {
        return this.c;
    }
}
