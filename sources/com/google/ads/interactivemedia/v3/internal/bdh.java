package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bdh implements azs {
    private bdh() {
    }

    public static bdh a(bho bhoVar) throws GeneralSecurityException {
        if (!bhoVar.h()) {
            throw new IllegalArgumentException("HpkePrivateKey is missing public_key field.");
        }
        if (!bhoVar.d().j()) {
            throw new IllegalArgumentException("HpkePrivateKey.public_key is missing params field.");
        }
        if (bhoVar.e().A()) {
            throw new IllegalArgumentException("HpkePrivateKey.private_key is empty.");
        }
        bhn b = bhoVar.d().b();
        bdl.b(b);
        bdl.c(b);
        bdl.a(b);
        int e = b.e();
        int i = e - 2;
        int i2 = bhl.a;
        if (e == 0) {
            throw null;
        }
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            String a = bhl.a(e);
            if (e != 0) {
                throw new IllegalArgumentException("Unable to determine KEM-encoding length for ".concat(String.valueOf(a)));
            }
            throw null;
        }
        int e2 = bhoVar.d().b().e();
        int i3 = e2 - 2;
        if (e2 == 0) {
            throw null;
        }
        if (i3 == 1) {
            bdu.a(bhoVar.e().B());
        } else {
            if (i3 != 2 && i3 != 3 && i3 != 4) {
                throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
            }
            bdu.b(bhoVar.e().B(), bhoVar.d().f().B(), bdr.g(bhoVar.d().b().e()));
        }
        return new bdh();
    }
}
