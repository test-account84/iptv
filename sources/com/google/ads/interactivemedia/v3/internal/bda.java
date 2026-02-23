package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bda {
    public static void a(bha bhaVar) throws GeneralSecurityException {
        bjh.t(c(bhaVar.d().e()));
        b(bhaVar.d().f());
        if (bhaVar.g() == bgx.a) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        bao.m(bhaVar.a().c());
    }

    public static String b(int i) throws NoSuchAlgorithmException {
        int i2 = bgx.a;
        int i3 = bhe.a;
        int i4 = i - 2;
        int i5 = bhf.a;
        if (i == 0) {
            throw null;
        }
        if (i4 == 1) {
            return "HmacSha1";
        }
        if (i4 == 2) {
            return "HmacSha384";
        }
        if (i4 == 3) {
            return "HmacSha256";
        }
        if (i4 == 4) {
            return "HmacSha512";
        }
        if (i4 != 5) {
            throw new NoSuchAlgorithmException("hash unsupported for HMAC: ".concat(String.valueOf(i != 0 ? bhf.toString$ar$edu$ddfc6937_0(i) : "null")));
        }
        return "HmacSha224";
    }

    public static int c(int i) throws GeneralSecurityException {
        int i2 = bgx.a;
        int i3 = bhe.a;
        int i4 = i - 2;
        int i5 = bhf.a;
        if (i == 0) {
            throw null;
        }
        if (i4 == 2) {
            return 1;
        }
        if (i4 == 3) {
            return 2;
        }
        if (i4 != 4) {
            throw new GeneralSecurityException("unknown curve type: ".concat(String.valueOf(i != 0 ? bhe.toString$ar$edu$a53f9db7_0(i) : "null")));
        }
        return 3;
    }

    public static int d(int i) throws GeneralSecurityException {
        int i2 = bgx.a;
        int i3 = bhe.a;
        int i4 = i - 2;
        int i5 = bhf.a;
        if (i == 0) {
            throw null;
        }
        int i6 = 1;
        if (i4 != 1) {
            i6 = 2;
            if (i4 != 2) {
                i6 = 3;
                if (i4 != 3) {
                    throw new GeneralSecurityException("unknown point format: ".concat(String.valueOf(i != 0 ? bgx.toString$ar$edu$33e92ce0_0(i) : "null")));
                }
            }
        }
        return i6;
    }
}
