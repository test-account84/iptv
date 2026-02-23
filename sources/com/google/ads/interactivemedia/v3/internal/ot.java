package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ot extends uq {
    private final List b;
    private final long c;

    public ot(long j, List list) {
        super(0L, list.size() - 1);
        this.c = j;
        this.b = list;
    }

    public final long a() {
        d();
        qb qbVar = (qb) this.b.get((int) c());
        return this.c + qbVar.g + qbVar.e;
    }

    public final long b() {
        d();
        return this.c + ((qb) this.b.get((int) c())).g;
    }
}
