package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.internal.axz;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class azf extends axz.i implements Runnable {
    private final Runnable b;

    public azf(Runnable runnable) {
        atp.k(runnable);
        this.b = runnable;
    }

    public final String e() {
        return "task=[" + this.b + "]";
    }

    public final void run() {
        try {
            this.b.run();
        } catch (RuntimeException | Error e) {
            o(e);
            throw e;
        }
    }
}
