package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bdn extends bea {
    public bdn(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ brs a(brs brsVar) throws GeneralSecurityException {
        byte[] b;
        byte[] c;
        bhm bhmVar = (bhm) brsVar;
        int i = bhl.a;
        int e = bhmVar.c().e();
        int i2 = e - 2;
        if (e == 0) {
            throw null;
        }
        if (i2 == 1) {
            b = bjh.b();
            c = bjh.c(b);
        } else {
            if (i2 != 2 && i2 != 3 && i2 != 4) {
                throw new GeneralSecurityException("Invalid KEM");
            }
            int g = bdr.g(bhmVar.c().e());
            KeyPair p = bjh.p(g);
            c = bjh.u(g, 1, p.getPublic().getW());
            b = p.getPrivate().getS().toByteArray();
        }
        bif l = bhp.l();
        l.u();
        l.s(bhmVar.c());
        l.t(bpb.t(c));
        bhp bhpVar = (bhp) l.aY();
        bif k = bho.k();
        k.x();
        k.w(bhpVar);
        k.v(bpb.t(b));
        return (bho) k.aY();
    }

    public final /* bridge */ /* synthetic */ brs b(bpb bpbVar) throws bqw {
        return bhm.b(bpbVar, bqb.a());
    }

    public final Map c() {
        HashMap hashMap = new HashMap();
        int i = bhl.b;
        int i2 = bhk.b;
        int i3 = bhj.b;
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", bdo.g(i, i2, i3, 1));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", bdo.g(i, i2, i3, 3));
        int i4 = bhj.c;
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", bdo.g(i, i2, i4, 1));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", bdo.g(i, i2, i4, 3));
        int i5 = bhj.d;
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", bdo.g(i, i2, i5, 1));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", bdo.g(i, i2, i5, 3));
        int i6 = bhl.c;
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", bdo.g(i6, i2, i3, 1));
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", bdo.g(i6, i2, i3, 3));
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", bdo.g(i6, i2, i4, 1));
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", bdo.g(i6, i2, i4, 3));
        int i7 = bhl.d;
        int i8 = bhk.c;
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", bdo.g(i7, i8, i3, 1));
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", bdo.g(i7, i8, i3, 3));
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", bdo.g(i7, i8, i4, 1));
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", bdo.g(i7, i8, i4, 3));
        int i9 = bhl.e;
        int i10 = bhk.d;
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", bdo.g(i9, i10, i3, 1));
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", bdo.g(i9, i10, i3, 3));
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", bdo.g(i9, i10, i4, 1));
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", bdo.g(i9, i10, i4, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void d(brs brsVar) throws GeneralSecurityException {
        bdr.a(((bhm) brsVar).c());
    }
}
