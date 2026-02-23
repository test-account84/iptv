package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bcy implements azt {
    final bal a;

    public bcy(bal balVar) {
        this.a = balVar;
        if (balVar.e()) {
            bfz b = bei.a().b();
            beg.a(balVar);
            b.a();
        }
    }

    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        bal balVar = this.a;
        if (balVar.a() == null) {
            throw new GeneralSecurityException("keyset without primary key");
        }
        byte[] y = bjh.y(balVar.a().e(), ((azt) this.a.a().d()).a(bArr, bArr2));
        this.a.a().a();
        int length = bArr.length;
        return y;
    }
}
