package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zzpy;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzqs extends zzpy.zzi implements Runnable {
    private final Runnable zzb;

    public zzqs(Runnable runnable) {
        runnable.getClass();
        this.zzb = runnable;
    }

    public final void run() {
        try {
            this.zzb.run();
        } catch (RuntimeException | Error e) {
            zzl(e);
            throw e;
        }
    }

    public final String zze() {
        return "task=[" + this.zzb.toString() + "]";
    }
}
