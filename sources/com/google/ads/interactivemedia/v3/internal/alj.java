package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class alj implements Callable {
    public final /* synthetic */ all a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.google.ads.interactivemedia.v3.impl.data.bh c;

    public /* synthetic */ alj(all allVar, String str, com.google.ads.interactivemedia.v3.impl.data.bh bhVar) {
        this.a = allVar;
        this.b = str;
        this.c = bhVar;
    }

    public final Object call() {
        return this.a.a(this.b, this.c);
    }
}
