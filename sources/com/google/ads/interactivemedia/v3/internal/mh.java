package com.google.ads.interactivemedia.v3.internal;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class mh extends mf {
    final mn e;
    final mn f;
    final long g;

    public mh(mb mbVar, long j, long j2, long j3, long j4, long j5, List list, long j6, mn mnVar, mn mnVar2, long j7, long j8) {
        super(mbVar, j, j2, j3, j5, list, j6, j7, j8);
        this.e = mnVar;
        this.f = mnVar2;
        this.g = j4;
    }

    public final long c(long j) {
        if (this.c != null) {
            return r0.size();
        }
        long j2 = this.g;
        if (j2 != -1) {
            return (j2 - this.a) + 1;
        }
        if (j != -9223372036854775807L) {
            return axt.a(BigInteger.valueOf(j).multiply(BigInteger.valueOf(this.i)), BigInteger.valueOf(this.b).multiply(BigInteger.valueOf(1000000L)), RoundingMode.CEILING).longValue();
        }
        return -1L;
    }

    public final mb g(me meVar, long j) {
        List list = this.c;
        long j2 = list != null ? ((mi) list.get((int) (j - this.a))).a : (j - this.a) * this.b;
        mn mnVar = this.f;
        s sVar = meVar.b;
        return new mb(mnVar.b(sVar.a, j, sVar.h, j2), 0L, -1L);
    }

    public final mb i(me meVar) {
        mn mnVar = this.e;
        if (mnVar == null) {
            return this.h;
        }
        s sVar = meVar.b;
        return new mb(mnVar.b(sVar.a, 0L, sVar.h, 0L), 0L, -1L);
    }
}
