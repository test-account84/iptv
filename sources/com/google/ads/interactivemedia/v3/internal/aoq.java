package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aoq extends apj {
    private final anx h;

    public aoq(anw anwVar, agl aglVar, int i, anx anxVar, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "DEi5JrQn0pxSuKS2Ij/fpEA7I+0FPLXDsBWBfvVwt/zwZUJJ4fnydbsyET2LCYMF", "Jj1vyuWfy0iUak+iXdGffQYzyyVnoa3nOmSynhrPgns=", aglVar, i, 85, null, null, null);
        this.h = anxVar;
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        long[] jArr = (long[]) this.d.invoke((Object) null, new Object[]{Long.valueOf(this.h.d()), Long.valueOf(this.h.h()), Long.valueOf(this.h.b()), Long.valueOf(this.h.f())});
        synchronized (this.g) {
            this.g.ae(jArr[0]);
            this.g.ad(jArr[1]);
        }
    }
}
