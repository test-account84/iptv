package com.google.ads.interactivemedia.v3.internal;

import android.view.Surface;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class xw {
    public static void a(Surface surface, float f) {
        try {
            T1.a(surface, f, f == 0.0f ? 0 : 1);
        } catch (IllegalStateException e) {
            cd.c("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e);
        }
    }
}
