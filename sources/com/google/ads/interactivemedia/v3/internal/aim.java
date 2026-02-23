package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdsRequest;
import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class aim implements Callable {
    public final /* synthetic */ aiq a;
    public final /* synthetic */ AdsRequest b;

    public /* synthetic */ aim(aiq aiqVar, AdsRequest adsRequest) {
        this.a = aiqVar;
        this.b = adsRequest;
    }

    public final Object call() {
        return this.a.f(this.b);
    }
}
