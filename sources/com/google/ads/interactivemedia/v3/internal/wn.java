package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class wn {
    private final Handler a;
    private final wp b;
    private boolean c;

    public wn(Handler handler, wp wpVar) {
        this.a = handler;
        this.b = wpVar;
    }

    public static /* bridge */ /* synthetic */ Handler a(wn wnVar) {
        return wnVar.a;
    }

    public static /* bridge */ /* synthetic */ wp b(wn wnVar) {
        return wnVar.b;
    }

    public static /* bridge */ /* synthetic */ boolean d(wn wnVar) {
        return wnVar.c;
    }

    public final void c() {
        this.c = true;
    }
}
