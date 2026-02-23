package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bdi implements azt {
    private static final byte[] a = new byte[0];
    private final bhp b;
    private final bdj c;
    private final bdf d;
    private final bde e;

    private bdi(bhp bhpVar, bdj bdjVar, bde bdeVar, bdf bdfVar) {
        this.b = bhpVar;
        this.c = bdjVar;
        this.e = bdeVar;
        this.d = bdfVar;
    }

    public static bdi b(bhp bhpVar) throws GeneralSecurityException {
        if (bhpVar.f().A()) {
            throw new IllegalArgumentException("HpkePublicKey.public_key is empty.");
        }
        bhn b = bhpVar.b();
        return new bdi(bhpVar, bdl.b(b), bdl.c(b), bdl.a(b));
    }

    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArr3 = bArr2;
        bhp bhpVar = this.b;
        bdj bdjVar = this.c;
        bde bdeVar = this.e;
        bdf bdfVar = this.d;
        bdk a2 = bdjVar.a(bhpVar.f().B());
        bdg c = bdg.c(a2.a(), a2.b(), bdjVar, bdeVar, bdfVar, bArr3);
        return bjh.y(c.a(), c.b(bArr, a));
    }
}
