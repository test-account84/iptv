package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class pb {
    private final oq h;
    private final nu c = new nk();
    private final ql b = new pq();
    private final pr g = pv.a;
    private final ox a = ox.a;
    private final ws i = new ws();
    private final ws j = new ws();
    private final int e = 1;
    private final long f = -9223372036854775807L;
    private final boolean d = true;

    public pb(cx cxVar) {
        this.h = new oq(cxVar);
    }

    public final pc a(ai aiVar) {
        af.s(aiVar.b);
        ql qlVar = this.b;
        List list = aiVar.b.e;
        ql pwVar = !list.isEmpty() ? new pw(qlVar, list) : qlVar;
        oq oqVar = this.h;
        ox oxVar = this.a;
        ws wsVar = this.j;
        nt a = this.c.a(aiVar);
        ws wsVar2 = this.i;
        return new pc(aiVar, oqVar, oxVar, wsVar, a, wsVar2, new pv(this.h, wsVar2, pwVar, null, null, null), -9223372036854775807L, true, 1, null, null, null, null);
    }
}
