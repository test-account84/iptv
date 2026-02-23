package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class aik implements Callable {
    public final /* synthetic */ Object a;
    private final /* synthetic */ int b;

    public /* synthetic */ aik(aiq aiqVar, int i) {
        this.b = i;
        this.a = aiqVar;
    }

    public final Object call() {
        int i = this.b;
        return i != 0 ? i != 1 ? i != 2 ? ((alq) this.a).a() : ((aiq) this.a).g() : ((ali) this.a).a() : ((alx) this.a).b();
    }

    public /* synthetic */ aik(ali aliVar, int i) {
        this.b = i;
        this.a = aliVar;
    }

    public /* synthetic */ aik(alq alqVar, int i) {
        this.b = i;
        this.a = alqVar;
    }

    public /* synthetic */ aik(alx alxVar, int i) {
        this.b = i;
        this.a = alxVar;
    }
}
