package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ck implements bn {
    public final long a() {
        return SystemClock.elapsedRealtime();
    }

    public final bv b(Looper looper, Handler.Callback callback) {
        return new cm(new Handler(looper, callback));
    }
}
