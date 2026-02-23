package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bdl {
    public static bdf a(bhn bhnVar) throws GeneralSecurityException {
        if (bhnVar.c() == bhj.b) {
            return new bdc(16);
        }
        if (bhnVar.c() == bhj.c) {
            return new bdc(32);
        }
        if (bhnVar.c() == bhj.d) {
            return new bdd();
        }
        throw new IllegalArgumentException("Unrecognized HPKE AEAD identifier");
    }

    public static bdj b(bhn bhnVar) throws GeneralSecurityException {
        if (bhnVar.e() == bhl.b) {
            return new bdt(new bde("HmacSha256"));
        }
        if (bhnVar.e() == bhl.c) {
            return bds.c(1);
        }
        if (bhnVar.e() == bhl.d) {
            return bds.c(2);
        }
        if (bhnVar.e() == bhl.e) {
            return bds.c(3);
        }
        throw new IllegalArgumentException("Unrecognized HPKE KEM identifier");
    }

    public static bde c(bhn bhnVar) {
        if (bhnVar.d() == bhk.b) {
            return new bde("HmacSha256");
        }
        if (bhnVar.d() == bhk.c) {
            return new bde("HmacSha384");
        }
        if (bhnVar.d() == bhk.d) {
            return new bde("HmacSha512");
        }
        throw new IllegalArgumentException("Unrecognized HPKE KDF identifier");
    }
}
