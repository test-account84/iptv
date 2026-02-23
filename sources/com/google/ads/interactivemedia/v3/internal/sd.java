package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class sd implements uf {
    public final uf a;
    final /* synthetic */ se b;
    private boolean c;

    public sd(se seVar, uf ufVar) {
        this.b = seVar;
        this.a = ufVar;
    }

    public final int a(go goVar, ef efVar, int i) {
        if (this.b.j()) {
            return -3;
        }
        if (this.c) {
            efVar.c(4);
            return -4;
        }
        int a = this.a.a(goVar, efVar, i);
        if (a == -5) {
            s sVar = goVar.b;
            af.s(sVar);
            int i2 = sVar.B;
            if (i2 != 0 || sVar.C != 0) {
                int i3 = this.b.b != Long.MIN_VALUE ? 0 : sVar.C;
                r b = sVar.b();
                b.N(i2);
                b.O(i3);
                goVar.b = b.v();
            }
            return -5;
        }
        se seVar = this.b;
        long j = seVar.b;
        if (j == Long.MIN_VALUE || ((a != -4 || efVar.d < j) && !(a == -3 && seVar.bo() == Long.MIN_VALUE && !efVar.c))) {
            return a;
        }
        efVar.b();
        efVar.c(4);
        this.c = true;
        return -4;
    }

    public final int b(long j) {
        if (this.b.j()) {
            return -3;
        }
        return this.a.b(j);
    }

    public final void c() {
        this.c = false;
    }

    public final void d() throws IOException {
        this.a.d();
    }

    public final boolean g() {
        return !this.b.j() && this.a.g();
    }
}
