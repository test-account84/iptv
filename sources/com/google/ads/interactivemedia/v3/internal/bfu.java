package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bfu implements bag {
    private final bal a;

    public /* synthetic */ bfu(bal balVar) {
        this.a = balVar;
        if (balVar.e()) {
            bfz b = bei.a().b();
            beg.a(balVar);
            b.a();
            b.a();
        }
    }

    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        if (this.a.a().c().equals(bid.c)) {
            bArr = bjh.y(bArr, bfv.d());
        }
        byte[] y = bjh.y(this.a.a().e(), ((bag) this.a.a().d()).a(bArr));
        this.a.a().a();
        return y;
    }
}
