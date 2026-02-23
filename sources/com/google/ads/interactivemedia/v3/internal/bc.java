package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bc {
    public Object a;
    public Object b;
    public int c;
    public long d;
    public long e;
    public boolean f;
    private b g = b.a;

    public final int a(int i) {
        return this.g.a(i).b;
    }

    public final int b(long j) {
        return -1;
    }

    public final int c(long j) {
        return -1;
    }

    public final int d(int i) {
        return this.g.a(i).a();
    }

    public final int e(int i, int i2) {
        return this.g.a(i).b(i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && bc.class.equals(obj.getClass())) {
            bc bcVar = (bc) obj;
            if (cq.V(this.a, bcVar.a) && cq.V(this.b, bcVar.b) && this.c == bcVar.c && this.d == bcVar.d && this.e == bcVar.e && this.f == bcVar.f && cq.V(this.g, bcVar.g)) {
                return true;
            }
        }
        return false;
    }

    public final long f(int i, int i2) {
        a a = this.g.a(i);
        if (a.b != -1) {
            return a.e[i2];
        }
        return -9223372036854775807L;
    }

    public final long g() {
        return cq.x(this.e);
    }

    public final void h() {
        int i = this.g.b;
    }

    public final int hashCode() {
        Object obj = this.a;
        int hashCode = ((obj == null ? 0 : obj.hashCode()) + 217) * 31;
        Object obj2 = this.b;
        int hashCode2 = obj2 != null ? obj2.hashCode() : 0;
        int i = this.c;
        long j = this.d;
        long j2 = this.e;
        return ((((((((((hashCode + hashCode2) * 31) + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31) + (this.f ? 1 : 0)) * 31) + this.g.hashCode();
    }

    public final void i(int i) {
        long j = this.g.a(i).a;
    }

    public final void j() {
        long j = this.g.c;
    }

    public final void k(int i) {
        long j = this.g.a(i).f;
    }

    public final void l(int i) {
        boolean z = this.g.a(i).g;
    }

    public final bc m(Object obj, Object obj2, long j, long j2) {
        n(obj, obj2, j, j2, b.a, false);
        return this;
    }

    public final void n(Object obj, Object obj2, long j, long j2, b bVar, boolean z) {
        this.a = obj;
        this.b = obj2;
        this.c = 0;
        this.d = j;
        this.e = j2;
        this.g = bVar;
        this.f = z;
    }
}
