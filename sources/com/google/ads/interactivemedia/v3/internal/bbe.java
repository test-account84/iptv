package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bbe extends bea {
    final /* synthetic */ bbf a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bbe(bbf bbfVar, Class cls) {
        super(cls);
        this.a = bbfVar;
    }

    public final /* bridge */ /* synthetic */ brs a(brs brsVar) throws GeneralSecurityException {
        bif g = bgp.g();
        g.ah(bpb.t(bjf.b(((bgq) brsVar).a())));
        g.ai();
        return (bgp) g.aY();
    }

    public final /* bridge */ /* synthetic */ brs b(bpb bpbVar) throws bqw {
        return bgq.c(bpbVar, bqb.a());
    }

    public final Map c() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM", bbf.g(16, 1));
        hashMap.put("AES128_GCM_RAW", bbf.g(16, 3));
        hashMap.put("AES256_GCM", bbf.g(32, 1));
        hashMap.put("AES256_GCM_RAW", bbf.g(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void d(brs brsVar) throws GeneralSecurityException {
        bjg.a(((bgq) brsVar).a());
    }
}
