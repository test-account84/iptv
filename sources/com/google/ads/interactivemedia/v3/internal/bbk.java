package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bbk extends bea {
    final /* synthetic */ bbl a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bbk(bbl bblVar, Class cls) {
        super(cls);
        this.a = bblVar;
    }

    public final /* bridge */ /* synthetic */ brs a(brs brsVar) throws GeneralSecurityException {
        bif g = bgv.g();
        g.Z();
        g.Y(bpb.t(bjf.b(32)));
        return (bgv) g.aY();
    }

    public final /* bridge */ /* synthetic */ brs b(bpb bpbVar) throws bqw {
        return bgw.c(bpbVar, bqb.a());
    }

    public final Map c() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("CHACHA20_POLY1305", new bdz(bgw.b(), 1));
        hashMap.put("CHACHA20_POLY1305_RAW", new bdz(bgw.b(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void d(brs brsVar) throws GeneralSecurityException {
    }
}
