package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class fu {
    public static iw a(Context context, gc gcVar, boolean z) {
        is k = is.k(context);
        if (k == null) {
            cd.e("ExoPlayerImpl", "MediaMetricsService unavailable.");
            return new iw(X.a());
        }
        if (z) {
            gcVar.M(k);
        }
        return new iw(k.j());
    }
}
