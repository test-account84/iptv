package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bav extends bea {
    final /* synthetic */ baw a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bav(baw bawVar, Class cls) {
        super(cls);
        this.a = bawVar;
    }

    public final /* bridge */ /* synthetic */ brs a(brs brsVar) throws GeneralSecurityException {
        bgi bgiVar = (bgi) brsVar;
        brs a = new baz().a().a(bgiVar.c());
        brs a2 = new bfi().a().a(bgiVar.d());
        bif j = bgh.j();
        j.ax((bgj) a);
        j.ay((bhg) a2);
        j.az(0);
        return (bgh) j.aY();
    }

    public final /* bridge */ /* synthetic */ brs b(bpb bpbVar) throws bqw {
        return bgi.b(bpbVar, bqb.a());
    }

    public final Map c() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        int i = bhf.d;
        hashMap.put("AES128_CTR_HMAC_SHA256", baw.g(16, 16, i, 1));
        hashMap.put("AES128_CTR_HMAC_SHA256_RAW", baw.g(16, 16, i, 3));
        hashMap.put("AES256_CTR_HMAC_SHA256", baw.g(32, 32, i, 1));
        hashMap.put("AES256_CTR_HMAC_SHA256_RAW", baw.g(32, 32, i, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void d(brs brsVar) throws GeneralSecurityException {
        bgi bgiVar = (bgi) brsVar;
        new baz().a().d(bgiVar.c());
        new bfi().a().d(bgiVar.d());
        bjg.a(bgiVar.c().a());
    }
}
