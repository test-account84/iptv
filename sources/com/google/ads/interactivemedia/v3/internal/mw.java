package com.google.ads.interactivemedia.v3.internal;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;

@SuppressLint({"HandlerLeak"})
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class mw extends Handler {
    final /* synthetic */ my a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mw(my myVar, Looper looper) {
        super(looper);
        this.a = myVar;
    }

    public final void handleMessage(Message message) {
        Pair pair = (Pair) message.obj;
        Object obj = pair.first;
        Object obj2 = pair.second;
        int i = message.what;
        if (i == 0) {
            my.g(this.a, obj, obj2);
        } else {
            if (i != 1) {
                return;
            }
            my.f(this.a, obj, obj2);
        }
    }
}
