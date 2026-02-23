package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class ain implements Callable {
    public final /* synthetic */ aiq a;
    public final /* synthetic */ AdsRequest b;
    public final /* synthetic */ azd c;
    public final /* synthetic */ AdDisplayContainer d;
    public final /* synthetic */ azd e;
    public final /* synthetic */ azd f;
    public final /* synthetic */ azd g;
    public final /* synthetic */ String h;

    public /* synthetic */ ain(aiq aiqVar, AdsRequest adsRequest, azd azdVar, AdDisplayContainer adDisplayContainer, azd azdVar2, azd azdVar3, azd azdVar4, String str) {
        this.a = aiqVar;
        this.b = adsRequest;
        this.c = azdVar;
        this.d = adDisplayContainer;
        this.e = azdVar2;
        this.f = azdVar3;
        this.g = azdVar4;
        this.h = str;
    }

    public final Object call() {
        this.a.n(this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        return null;
    }
}
