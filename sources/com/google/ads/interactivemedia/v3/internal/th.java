package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class th implements Runnable {
    public final /* synthetic */ tj a;
    public final /* synthetic */ tk b;
    public final /* synthetic */ sw c;
    public final /* synthetic */ tb d;
    public final /* synthetic */ IOException e;
    public final /* synthetic */ boolean f;

    public /* synthetic */ th(tj tjVar, tk tkVar, sw swVar, tb tbVar, IOException iOException, boolean z) {
        this.a = tjVar;
        this.b = tkVar;
        this.c = swVar;
        this.d = tbVar;
        this.e = iOException;
        this.f = z;
    }

    public final void run() {
        tj tjVar = this.a;
        this.b.ah(tjVar.a, tjVar.b, this.c, this.d, this.e, this.f);
    }
}
