package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class hv {
    public final long a;
    public final be b;
    public final int c;
    public final te d;
    public final long e;
    public final be f;
    public final int g;
    public final te h;
    public final long i;
    public final long j;

    public hv(long j, be beVar, int i, te teVar, long j2, be beVar2, int i2, te teVar2, long j3, long j4) {
        this.a = j;
        this.b = beVar;
        this.c = i;
        this.d = teVar;
        this.e = j2;
        this.f = beVar2;
        this.g = i2;
        this.h = teVar2;
        this.i = j3;
        this.j = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && hv.class == obj.getClass()) {
            hv hvVar = (hv) obj;
            if (this.a == hvVar.a && this.c == hvVar.c && this.e == hvVar.e && this.g == hvVar.g && this.i == hvVar.i && this.j == hvVar.j && com.google.ads.interactivemedia.v3.impl.data.k.c(this.b, hvVar.b) && com.google.ads.interactivemedia.v3.impl.data.k.c(this.d, hvVar.d) && com.google.ads.interactivemedia.v3.impl.data.k.c(this.f, hvVar.f) && com.google.ads.interactivemedia.v3.impl.data.k.c(this.h, hvVar.h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.a), this.b, Integer.valueOf(this.c), this.d, Long.valueOf(this.e), this.f, Integer.valueOf(this.g), this.h, Long.valueOf(this.i), Long.valueOf(this.j)});
    }
}
