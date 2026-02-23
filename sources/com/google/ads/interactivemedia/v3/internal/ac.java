package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ac {
    public final long a;
    public final long b;
    public final long c;
    public final float d;
    public final float e;

    public /* synthetic */ ac(ab abVar) {
        long e = ab.e(abVar);
        long d = ab.d(abVar);
        long c = ab.c(abVar);
        float b = ab.b(abVar);
        float a = ab.a(abVar);
        this.a = e;
        this.b = d;
        this.c = c;
        this.d = b;
        this.e = a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ac)) {
            return false;
        }
        ac acVar = (ac) obj;
        return this.a == acVar.a && this.b == acVar.b && this.c == acVar.c && this.d == acVar.d && this.e == acVar.e;
    }

    public final int hashCode() {
        long j = this.a;
        long j2 = this.b;
        long j3 = this.c;
        int i = ((((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31;
        float f = this.d;
        int floatToIntBits = (i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.e;
        return floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
    }
}
