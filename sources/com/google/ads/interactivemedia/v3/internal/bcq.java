package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bcq extends bea {
    final /* synthetic */ bcr a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bcq(bcr bcrVar, Class cls) {
        super(cls);
        this.a = bcrVar;
    }

    public final /* bridge */ /* synthetic */ brs a(brs brsVar) throws GeneralSecurityException {
        bgz bgzVar = (bgz) brsVar;
        KeyPair p = bjh.p(bda.c(bgzVar.c().d().e()));
        ECPublicKey eCPublicKey = p.getPublic();
        ECPrivateKey eCPrivateKey = p.getPrivate();
        ECPoint w = eCPublicKey.getW();
        bif m = bhc.m();
        m.N();
        m.M(bgzVar.c());
        m.O(bpb.t(w.getAffineX().toByteArray()));
        m.P(bpb.t(w.getAffineY().toByteArray()));
        bhc bhcVar = (bhc) m.aY();
        bif j = bhb.j();
        j.S();
        j.R(bhcVar);
        j.Q(bpb.t(eCPrivateKey.getS().toByteArray()));
        return (bhb) j.aY();
    }

    public final /* bridge */ /* synthetic */ brs b(bpb bpbVar) throws bqw {
        return bgz.b(bpbVar, bqb.a());
    }

    public final Map c() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        int i = bhe.b;
        int i2 = bhf.d;
        int i3 = bgx.b;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", bcr.h(i, i2, i3, ban.a("AES128_GCM"), bcr.g(), 1));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", bcr.h(i, i2, i3, ban.a("AES128_GCM"), bcr.g(), 3));
        int i4 = bgx.c;
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", bcr.h(i, i2, i4, ban.a("AES128_GCM"), bcr.g(), 1));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", bcr.h(i, i2, i4, ban.a("AES128_GCM"), bcr.g(), 3));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", bcr.h(i, i2, i4, ban.a("AES128_GCM"), bcr.g(), 3));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", bcr.h(i, i2, i3, ban.a("AES128_CTR_HMAC_SHA256"), bcr.g(), 1));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", bcr.h(i, i2, i3, ban.a("AES128_CTR_HMAC_SHA256"), bcr.g(), 3));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", bcr.h(i, i2, i4, ban.a("AES128_CTR_HMAC_SHA256"), bcr.g(), 1));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", bcr.h(i, i2, i4, ban.a("AES128_CTR_HMAC_SHA256"), bcr.g(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void d(brs brsVar) throws GeneralSecurityException {
        bda.a(((bgz) brsVar).c());
    }
}
