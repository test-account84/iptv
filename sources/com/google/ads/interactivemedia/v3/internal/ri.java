package com.google.ads.interactivemedia.v3.internal;

import android.media.metrics.LogSessionId;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ri {
    public static void a(rd rdVar, iw iwVar) {
        LogSessionId a = iwVar.a();
        if (d1.a(a, X.a())) {
            return;
        }
        rdVar.b.setString("log-session-id", D1.a(a));
    }
}
