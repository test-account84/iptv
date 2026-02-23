package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class vo implements wa {
    public final /* synthetic */ wd a;
    public final /* synthetic */ vu b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ vo(wd wdVar, vu vuVar, boolean z) {
        this.a = wdVar;
        this.b = vuVar;
        this.c = z;
    }

    public final List a(int i, bf bfVar, int[] iArr) {
        wd wdVar = this.a;
        vu vuVar = this.b;
        boolean z = this.c;
        vn vnVar = new vn(wdVar);
        avk j = avo.j();
        for (int i2 = 0; i2 < bfVar.a; i2++) {
            j.g(new vr(i, bfVar, i2, vuVar, iArr[i2], z, vnVar));
        }
        return j.f();
    }
}
