package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class vw implements Executor {
    public final /* synthetic */ Handler a;
    private final /* synthetic */ int b;

    public /* synthetic */ vw(Handler handler, int i) {
        this.b = i;
        this.a = handler;
    }

    public final void execute(Runnable runnable) {
        int i = this.b;
        this.a.post(runnable);
    }
}
