package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class gr {
    public final te a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public gr(te teVar, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, boolean z4) {
        af.u(!z4 || z2);
        af.u(!z3 || z2);
        af.u(true);
        this.a = teVar;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = false;
        this.g = z2;
        this.h = z3;
        this.i = z4;
    }

    public final gr a(long j) {
        return j == this.c ? this : new gr(this.a, this.b, j, this.d, this.e, false, this.g, this.h, this.i);
    }

    public final gr b(long j) {
        return j == this.b ? this : new gr(this.a, j, this.c, this.d, this.e, false, this.g, this.h, this.i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && gr.class == obj.getClass()) {
            gr grVar = (gr) obj;
            if (this.b == grVar.b && this.c == grVar.c && this.d == grVar.d && this.e == grVar.e && this.g == grVar.g && this.h == grVar.h && this.i == grVar.i && cq.V(this.a, grVar.a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((this.a.hashCode() + 527) * 31) + ((int) this.b)) * 31) + ((int) this.c)) * 31) + ((int) this.d)) * 31) + ((int) this.e)) * 961) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0);
    }
}
