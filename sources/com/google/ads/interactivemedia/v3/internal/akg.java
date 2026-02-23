package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class akg implements Callable {
    public final /* synthetic */ akl a;
    public final /* synthetic */ com.google.ads.interactivemedia.v3.impl.data.bq b;

    public /* synthetic */ akg(akl aklVar, com.google.ads.interactivemedia.v3.impl.data.bq bqVar) {
        this.a = aklVar;
        this.b = bqVar;
    }

    public final Object call() {
        return this.a.b(this.b);
    }
}
