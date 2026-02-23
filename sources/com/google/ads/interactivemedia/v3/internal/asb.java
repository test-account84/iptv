package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class asb implements Callable {
    public final /* synthetic */ asg a;
    private final /* synthetic */ int b;

    public /* synthetic */ asb(asg asgVar, int i) {
        this.b = i;
        this.a = asgVar;
    }

    public final Object call() {
        return this.b != 0 ? this.a.c() : this.a.d();
    }
}
