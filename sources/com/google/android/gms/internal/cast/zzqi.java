package com.google.android.gms.internal.cast;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import y5.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzqi extends zzqg implements b {
    public final void addListener(Runnable runnable, Executor executor) {
        zzc().addListener(runnable, executor);
    }

    public /* bridge */ /* synthetic */ Future zzb() {
        throw null;
    }

    public abstract b zzc();
}
