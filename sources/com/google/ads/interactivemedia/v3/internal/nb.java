package com.google.ads.interactivemedia.v3.internal;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

@SuppressLint({"HandlerLeak"})
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class nb extends Handler {
    final /* synthetic */ nj a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nb(nj njVar, Looper looper) {
        super(looper);
        this.a = njVar;
    }

    public final void handleMessage(Message message) {
        byte[] bArr = (byte[]) message.obj;
        if (bArr == null) {
            return;
        }
        for (my myVar : nj.k(this.a)) {
            if (myVar.n(bArr)) {
                myVar.i(message.what);
                return;
            }
        }
    }
}
