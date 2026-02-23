package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class akz {
    private aky b;
    private final Handler a = new Handler();
    private boolean c = false;

    public static /* synthetic */ void a(aky akyVar, Handler handler, long j) {
        akyVar.a();
        e(akyVar, handler, 200L);
    }

    private static void e(aky akyVar, Handler handler, long j) {
        handler.postDelayed(new akx(akyVar, handler, 200L), 200L);
    }

    public final void b(aky akyVar) {
        this.b = akyVar;
    }

    public final void c() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.a();
        e(this.b, this.a, 200L);
    }

    public final void d() {
        if (this.c) {
            this.c = false;
            this.a.removeCallbacksAndMessages((Object) null);
        }
    }
}
