package com.google.ads.interactivemedia.v3.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class eh extends BroadcastReceiver implements Runnable {
    final /* synthetic */ ej a;
    private final ei b;
    private final Handler c;

    public eh(ej ejVar, Handler handler, ei eiVar) {
        this.a = ejVar;
        this.c = handler;
        this.b = eiVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.c.post(this);
        }
    }

    public final void run() {
    }
}
