package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ay {
    public final Object a;
    public final int b;
    public final ai c;
    public final Object d;
    public final int e;
    public final long f;
    public final long g;
    public final int h;
    public final int i;

    public ay(Object obj, int i, ai aiVar, Object obj2, int i2, long j, long j2, int i3, int i4) {
        this.a = obj;
        this.b = i;
        this.c = aiVar;
        this.d = obj2;
        this.e = i2;
        this.f = j;
        this.g = j2;
        this.h = i3;
        this.i = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ay.class == obj.getClass()) {
            ay ayVar = (ay) obj;
            if (this.b == ayVar.b && this.e == ayVar.e && this.f == ayVar.f && this.g == ayVar.g && this.h == ayVar.h && this.i == ayVar.i && com.google.ads.interactivemedia.v3.impl.data.k.c(this.a, ayVar.a) && com.google.ads.interactivemedia.v3.impl.data.k.c(this.d, ayVar.d) && com.google.ads.interactivemedia.v3.impl.data.k.c(this.c, ayVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Integer.valueOf(this.b), this.c, this.d, Integer.valueOf(this.e), Long.valueOf(this.f), Long.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i)});
    }
}
