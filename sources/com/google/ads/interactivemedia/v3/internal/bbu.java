package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bbu extends bea {
    final /* synthetic */ bbv a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bbu(bbv bbvVar, Class cls) {
        super(cls);
        this.a = bbvVar;
    }

    public final /* bridge */ /* synthetic */ brs a(brs brsVar) throws GeneralSecurityException {
        bif b = big.b();
        b.b();
        b.a(bpb.t(bjf.b(32)));
        return (big) b.aY();
    }

    public final /* bridge */ /* synthetic */ brs b(bpb bpbVar) throws bqw {
        return bih.c(bpbVar, bqb.a());
    }

    public final Map c() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("XCHACHA20_POLY1305", new bdz(bih.b(), 1));
        hashMap.put("XCHACHA20_POLY1305_RAW", new bdz(bih.b(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void d(brs brsVar) throws GeneralSecurityException {
    }
}
