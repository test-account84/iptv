package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bbb extends bea {
    final /* synthetic */ bbc a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bbb(bbc bbcVar, Class cls) {
        super(cls);
        this.a = bbcVar;
    }

    public final /* bridge */ /* synthetic */ brs a(brs brsVar) throws GeneralSecurityException {
        bgn bgnVar = (bgn) brsVar;
        bif j = bgm.j();
        j.am(bpb.t(bjf.b(bgnVar.a())));
        j.an(bgnVar.d());
        j.ao();
        return (bgm) j.aY();
    }

    public final /* bridge */ /* synthetic */ brs b(bpb bpbVar) throws bqw {
        return bgn.c(bpbVar, bqb.a());
    }

    public final Map c() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_EAX", bbc.g(16, 1));
        hashMap.put("AES128_EAX_RAW", bbc.g(16, 3));
        hashMap.put("AES256_EAX", bbc.g(32, 1));
        hashMap.put("AES256_EAX_RAW", bbc.g(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void d(brs brsVar) throws GeneralSecurityException {
        bgn bgnVar = (bgn) brsVar;
        bjg.a(bgnVar.a());
        if (bgnVar.d().a() != 12 && bgnVar.d().a() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
