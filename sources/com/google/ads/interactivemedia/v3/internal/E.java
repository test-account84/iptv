package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioAttributes;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e {
    public final AudioAttributes a;

    public /* synthetic */ e(f fVar) {
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
        int i = cq.a;
        if (i >= 29) {
            c.a(usage, 1);
        }
        if (i >= 32) {
            d.a(usage, 0);
        }
        this.a = usage.build();
    }
}
