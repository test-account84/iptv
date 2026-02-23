package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class qu extends Handler {
    final /* synthetic */ qw a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qu(qw qwVar, Looper looper) {
        super(looper);
        this.a = qwVar;
    }

    public final void handleMessage(Message message) {
        qw.a(this.a, message);
    }
}
