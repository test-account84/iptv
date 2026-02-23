package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.StreamRequest;
import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class ail implements Callable {
    public final /* synthetic */ aiq a;
    public final /* synthetic */ StreamRequest b;
    public final /* synthetic */ azd c;
    public final /* synthetic */ azd d;
    public final /* synthetic */ azd e;
    public final /* synthetic */ azd f;
    public final /* synthetic */ String g;

    public /* synthetic */ ail(aiq aiqVar, StreamRequest streamRequest, azd azdVar, azd azdVar2, azd azdVar3, azd azdVar4, String str) {
        this.a = aiqVar;
        this.b = streamRequest;
        this.c = azdVar;
        this.d = azdVar2;
        this.e = azdVar3;
        this.f = azdVar4;
        this.g = str;
    }

    public final Object call() {
        this.a.o(this.b, this.c, this.d, this.e, this.f, this.g);
        return null;
    }
}
