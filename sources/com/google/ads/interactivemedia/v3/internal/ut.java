package com.google.ads.interactivemedia.v3.internal;

import android.util.SparseArray;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ut implements zk, uv {
    public static final ur a = ur.a;
    private static final zy c = new zy();
    private final zh d;
    private final int e;
    private final s f;
    private final SparseArray g = new SparseArray();
    private boolean h;
    private long i;
    private aab j;
    private s[] k;
    private zo l;

    public ut(zh zhVar, int i, s sVar) {
        this.d = zhVar;
        this.e = i;
        this.f = sVar;
    }

    public final yz a() {
        aab aabVar = this.j;
        if (aabVar instanceof yz) {
            return (yz) aabVar;
        }
        return null;
    }

    public final void b() {
        this.d.c();
    }

    public final boolean c(zi ziVar) throws IOException {
        int a2 = this.d.a(ziVar, c);
        af.w(a2 != 1);
        return a2 == 0;
    }

    public final s[] d() {
        return this.k;
    }

    public final void e(zo zoVar, long j, long j2) {
        this.l = zoVar;
        this.i = j2;
        if (!this.h) {
            this.d.b(this);
            if (j != -9223372036854775807L) {
                this.d.d(0L, j);
            }
            this.h = true;
            return;
        }
        zh zhVar = this.d;
        if (j == -9223372036854775807L) {
            j = 0;
        }
        zhVar.d(0L, j);
        for (int i = 0; i < this.g.size(); i++) {
            ((us) this.g.valueAt(i)).c(zoVar, j2);
        }
    }

    public final aae i(int i, int i2) {
        us usVar = (us) this.g.get(i);
        if (usVar == null) {
            af.w(this.k == null);
            usVar = new us(i, i2, i2 == this.e ? this.f : null);
            usVar.c(this.l, this.i);
            this.g.put(i, usVar);
        }
        return usVar;
    }

    public final void n() {
        s[] sVarArr = new s[this.g.size()];
        for (int i = 0; i < this.g.size(); i++) {
            s sVar = ((us) this.g.valueAt(i)).a;
            af.t(sVar);
            sVarArr[i] = sVar;
        }
        this.k = sVarArr;
    }

    public final void x(aab aabVar) {
        this.j = aabVar;
    }
}
