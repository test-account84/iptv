package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class lc {
    private final cx a;
    private final aeq d;
    private final nu b = new nk();
    private final ws e = new ws();
    private final long c = 30000;
    private final ws f = new ws();

    public lc(cx cxVar) {
        this.d = new aeq(cxVar);
        this.a = cxVar;
    }

    public final lh a(ai aiVar) {
        af.s(aiVar.b);
        lw lwVar = new lw();
        List list = aiVar.b.e;
        return new lh(aiVar, this.a, !list.isEmpty() ? new rz(lwVar, list) : lwVar, this.d, this.f, this.b.a(aiVar), this.e, 30000L, null, null, null, null);
    }
}
