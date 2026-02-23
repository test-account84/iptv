package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class kd {
    private Exception a;
    private long b;

    public final void a() {
        this.a = null;
    }

    public final void b(Exception exc) throws Exception {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.a == null) {
            this.a = exc;
            this.b = 100 + elapsedRealtime;
        }
        if (elapsedRealtime >= this.b) {
            Exception exc2 = this.a;
            if (exc2 != exc) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class}).invoke(exc2, new Object[]{exc});
                } catch (Exception unused) {
                }
            }
            Exception exc3 = this.a;
            a();
            throw exc3;
        }
    }
}
