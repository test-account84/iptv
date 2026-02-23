package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ahq implements Runnable {
    private final /* synthetic */ int a;

    public ahq(int i) {
        this.a = i;
    }

    public final void run() {
        if (this.a != 0) {
            aht.f(aht.c());
        } else if (aht.b() != null) {
            aht.b().post(aht.e());
            aht.b().postDelayed(aht.d(), 200L);
        }
    }
}
