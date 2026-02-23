package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioTrack;
import android.media.metrics.LogSessionId;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class jx {
    public static void a(AudioTrack audioTrack, iw iwVar) {
        LogSessionId a = iwVar.a();
        if (d1.a(a, X.a())) {
            return;
        }
        e1.a(audioTrack, a);
    }
}
