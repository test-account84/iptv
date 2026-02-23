package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bbi extends beb {
    public bbi() {
        super(bgr.class, new bbg(azo.class));
    }

    public static /* bridge */ /* synthetic */ bdz g(int i, int i2) {
        bif e = bgs.e();
        e.ad(i);
        return new bdz((bgs) e.aY(), i2);
    }

    public static void h() throws GeneralSecurityException {
        if (m()) {
            bao.o(new bbi());
        }
    }

    private static boolean m() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public final bea a() {
        return new bbh(this, bgs.class);
    }

    public final bhq b() {
        return bhq.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ brs c(bpb bpbVar) throws bqw {
        return bgr.c(bpbVar, bqb.a());
    }

    public final String d() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    public final /* bridge */ /* synthetic */ void e(brs brsVar) throws GeneralSecurityException {
        bgr bgrVar = (bgr) brsVar;
        bjg.b(bgrVar.a());
        bjg.a(bgrVar.d().d());
    }
}
