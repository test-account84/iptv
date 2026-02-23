package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aev implements Runnable {
    final /* synthetic */ aew a;
    private boolean b;

    public /* synthetic */ aev(aew aewVar) {
        this.a = aewVar;
    }

    public final void a() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.a.post(this);
    }

    public final void run() {
        this.b = false;
    }
}
