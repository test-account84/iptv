package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bfh extends bea {
    final /* synthetic */ bfi a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bfh(bfi bfiVar, Class cls) {
        super(cls);
        this.a = bfiVar;
    }

    public final /* bridge */ /* synthetic */ brs a(brs brsVar) throws GeneralSecurityException {
        bhh bhhVar = (bhh) brsVar;
        bif k = bhg.k();
        k.I();
        k.H(bhhVar.e());
        k.G(bpb.t(bjf.b(bhhVar.a())));
        return (bhg) k.aY();
    }

    public final /* bridge */ /* synthetic */ brs b(bpb bpbVar) throws bqw {
        return bhh.d(bpbVar, bqb.a());
    }

    public final Map c() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        int i = bhf.d;
        hashMap.put("HMAC_SHA256_128BITTAG", bfi.m(32, 16, i, 1));
        hashMap.put("HMAC_SHA256_128BITTAG_RAW", bfi.m(32, 16, i, 3));
        hashMap.put("HMAC_SHA256_256BITTAG", bfi.m(32, 32, i, 1));
        hashMap.put("HMAC_SHA256_256BITTAG_RAW", bfi.m(32, 32, i, 3));
        int i2 = bhf.e;
        hashMap.put("HMAC_SHA512_128BITTAG", bfi.m(64, 16, i2, 1));
        hashMap.put("HMAC_SHA512_128BITTAG_RAW", bfi.m(64, 16, i2, 3));
        hashMap.put("HMAC_SHA512_256BITTAG", bfi.m(64, 32, i2, 1));
        hashMap.put("HMAC_SHA512_256BITTAG_RAW", bfi.m(64, 32, i2, 3));
        hashMap.put("HMAC_SHA512_512BITTAG", bfi.m(64, 64, i2, 1));
        hashMap.put("HMAC_SHA512_512BITTAG_RAW", bfi.m(64, 64, i2, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void d(brs brsVar) throws GeneralSecurityException {
        bhh bhhVar = (bhh) brsVar;
        if (bhhVar.a() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        bfi.g(bhhVar.e());
    }
}
