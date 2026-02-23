package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bck extends bea {
    final /* synthetic */ bcl a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bck(bcl bclVar, Class cls) {
        super(cls);
        this.a = bclVar;
    }

    public final /* bridge */ /* synthetic */ brs a(brs brsVar) throws GeneralSecurityException {
        bif g = bgt.g();
        g.ab(bpb.t(bjf.b(((bgu) brsVar).a())));
        g.ac();
        return (bgt) g.aY();
    }

    public final /* bridge */ /* synthetic */ brs b(bpb bpbVar) throws bqw {
        return bgu.c(bpbVar, bqb.a());
    }

    public final Map c() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        bif e = bgu.e();
        e.aa();
        hashMap.put("AES256_SIV", new bdz((bgu) e.aY(), 1));
        bif e2 = bgu.e();
        e2.aa();
        hashMap.put("AES256_SIV_RAW", new bdz((bgu) e2.aY(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void d(brs brsVar) throws GeneralSecurityException {
        bgu bguVar = (bgu) brsVar;
        if (bguVar.a() == 64) {
            return;
        }
        throw new InvalidAlgorithmParameterException("invalid key size: " + bguVar.a() + ". Valid keys must have 64 bytes.");
    }
}
