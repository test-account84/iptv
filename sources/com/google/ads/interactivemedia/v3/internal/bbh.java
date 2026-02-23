package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bbh extends bea {
    final /* synthetic */ bbi a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bbh(bbi bbiVar, Class cls) {
        super(cls);
        this.a = bbiVar;
    }

    public final /* bridge */ /* synthetic */ brs a(brs brsVar) throws GeneralSecurityException {
        bif g = bgr.g();
        g.ae(bpb.t(bjf.b(((bgs) brsVar).a())));
        g.af();
        return (bgr) g.aY();
    }

    public final /* bridge */ /* synthetic */ brs b(bpb bpbVar) throws bqw {
        return bgs.c(bpbVar, bqb.a());
    }

    public final Map c() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM_SIV", bbi.g(16, 1));
        hashMap.put("AES128_GCM_SIV_RAW", bbi.g(16, 3));
        hashMap.put("AES256_GCM_SIV", bbi.g(32, 1));
        hashMap.put("AES256_GCM_SIV_RAW", bbi.g(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void d(brs brsVar) throws GeneralSecurityException {
        bjg.a(((bgs) brsVar).a());
    }
}
