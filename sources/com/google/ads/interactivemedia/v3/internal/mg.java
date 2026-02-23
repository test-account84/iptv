package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class mg extends mf {
    final List e;

    public mg(mb mbVar, long j, long j2, long j3, long j4, List list, long j5, List list2, long j6, long j7) {
        super(mbVar, j, j2, j3, j4, list, j5, j6, j7);
        this.e = list2;
    }

    public final long c(long j) {
        return this.e.size();
    }

    public final mb g(me meVar, long j) {
        return (mb) this.e.get((int) (j - this.a));
    }

    public final boolean h() {
        return true;
    }
}
