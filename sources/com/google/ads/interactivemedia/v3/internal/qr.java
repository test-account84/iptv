package com.google.ads.interactivemedia.v3.internal;

import android.os.HandlerThread;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class qr implements atq {
    public final /* synthetic */ int a;
    private final /* synthetic */ int b;

    public /* synthetic */ qr(int i, int i2) {
        this.b = i2;
        this.a = i;
    }

    public final Object a() {
        return this.b != 0 ? new HandlerThread(qt.d(this.a)) : new HandlerThread(qt.e(this.a));
    }
}
