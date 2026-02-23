package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bcl extends beb {
    public bcl() {
        super(bgt.class, new bcj(azr.class));
    }

    public final bea a() {
        return new bck(this, bgu.class);
    }

    public final bhq b() {
        return bhq.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ brs c(bpb bpbVar) throws bqw {
        return bgt.c(bpbVar, bqb.a());
    }

    public final String d() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    public final /* bridge */ /* synthetic */ void e(brs brsVar) throws GeneralSecurityException {
        bgt bgtVar = (bgt) brsVar;
        bjg.b(bgtVar.a());
        if (bgtVar.d().d() == 64) {
            return;
        }
        throw new InvalidKeyException("invalid key size: " + bgtVar.d().d() + ". Valid keys must have 64 bytes.");
    }
}
