package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bd {
    public static final Object a = new Object();
    private static final ai r;
    public Object b = a;
    public ai c = r;
    public Object d;
    public long e;
    public long f;
    public long g;
    public boolean h;
    public boolean i;

    @Deprecated
    public boolean j;
    public ac k;
    public boolean l;
    public long m;
    public long n;
    public int o;
    public int p;
    public long q;

    static {
        v vVar = new v();
        vVar.b("bundled.androidx.media3.common.Timeline");
        vVar.c(Uri.EMPTY);
        r = vVar.a();
    }

    public final long a() {
        return cq.x(this.m);
    }

    public final long b() {
        return cq.x(this.n);
    }

    public final boolean c() {
        af.w(this.j == (this.k != null));
        return this.k != null;
    }

    public final void d(Object obj, ai aiVar, Object obj2, long j, long j2, long j3, boolean z, boolean z2, ac acVar, long j4, long j5, int i, long j6) {
        this.b = obj;
        this.c = aiVar != null ? aiVar : r;
        this.d = obj2;
        this.e = j;
        this.f = j2;
        this.g = j3;
        this.h = z;
        this.i = z2;
        this.j = acVar != null;
        this.k = acVar;
        this.m = j4;
        this.n = j5;
        this.o = 0;
        this.p = i;
        this.q = j6;
        this.l = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && bd.class.equals(obj.getClass())) {
            bd bdVar = (bd) obj;
            if (cq.V(this.b, bdVar.b) && cq.V(this.c, bdVar.c) && cq.V(this.d, bdVar.d) && cq.V(this.k, bdVar.k) && this.e == bdVar.e && this.f == bdVar.f && this.g == bdVar.g && this.h == bdVar.h && this.i == bdVar.i && this.l == bdVar.l && this.m == bdVar.m && this.n == bdVar.n && this.o == bdVar.o && this.p == bdVar.p && this.q == bdVar.q) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((this.b.hashCode() + 217) * 31) + this.c.hashCode()) * 31;
        Object obj = this.d;
        int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        ac acVar = this.k;
        int hashCode3 = acVar != null ? acVar.hashCode() : 0;
        long j = this.e;
        long j2 = this.f;
        long j3 = this.g;
        boolean z = this.h;
        boolean z2 = this.i;
        boolean z3 = this.l;
        long j4 = this.m;
        long j5 = this.n;
        int i = this.o;
        int i2 = this.p;
        long j6 = this.q;
        return ((((((((((((((((((((((hashCode2 + hashCode3) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31) + (z ? 1 : 0)) * 31) + (z2 ? 1 : 0)) * 31) + (z3 ? 1 : 0)) * 31) + ((int) ((j4 >>> 32) ^ j4))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + i) * 31) + i2) * 31) + ((int) ((j6 >>> 32) ^ j6));
    }
}
