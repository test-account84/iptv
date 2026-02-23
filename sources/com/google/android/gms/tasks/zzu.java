package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzu implements Executor {
    private final Handler zza = new com.google.android.gms.internal.tasks.zza(Looper.getMainLooper());

    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
