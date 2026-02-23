package com.google.ads.interactivemedia.v3.internal;

import android.media.metrics.LogSessionId;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class iw {
    private final iv a;

    static {
        if (cq.a < 31) {
            new iw();
        } else {
            iv ivVar = iv.a;
        }
    }

    public iw() {
        this((iv) null);
        af.w(cq.a < 31);
    }

    public final LogSessionId a() {
        iv ivVar = this.a;
        af.s(ivVar);
        return ivVar.b;
    }

    public iw(LogSessionId logSessionId) {
        this(new iv(logSessionId));
    }

    private iw(iv ivVar) {
        this.a = ivVar;
    }
}
