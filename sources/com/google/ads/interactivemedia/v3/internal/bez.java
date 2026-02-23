package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bez extends bea {
    public bez(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ brs a(brs brsVar) throws GeneralSecurityException {
        bgf bgfVar = (bgf) brsVar;
        bif j = bge.j();
        j.aF();
        j.aD(bpb.t(bjf.b(bgfVar.a())));
        j.aE(bgfVar.d());
        return (bge) j.aY();
    }

    public final /* bridge */ /* synthetic */ brs b(bpb bpbVar) throws bqw {
        return bgf.c(bpbVar, bqb.a());
    }

    public final Map c() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        bif g = bgf.g();
        g.aB();
        bif e = bgg.e();
        e.aA();
        g.aC((bgg) e.aY());
        hashMap.put("AES_CMAC", new bdz((bgf) g.aY(), 1));
        bif g2 = bgf.g();
        g2.aB();
        bif e2 = bgg.e();
        e2.aA();
        g2.aC((bgg) e2.aY());
        hashMap.put("AES256_CMAC", new bdz((bgf) g2.aY(), 1));
        bif g3 = bgf.g();
        g3.aB();
        bif e3 = bgg.e();
        e3.aA();
        g3.aC((bgg) e3.aY());
        hashMap.put("AES256_CMAC_RAW", new bdz((bgf) g3.aY(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void d(brs brsVar) throws GeneralSecurityException {
        bgf bgfVar = (bgf) brsVar;
        bfa.g(bgfVar.d());
        bfa.h(bgfVar.a());
    }
}
