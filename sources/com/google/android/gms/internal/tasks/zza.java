package com.google.android.gms.internal.tasks;

import android.os.Handler;
import android.os.Looper;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zza extends Handler {
    private final Looper zza;

    public zza() {
        this.zza = Looper.getMainLooper();
    }

    public zza(Looper looper) {
        super(looper);
        this.zza = Looper.getMainLooper();
    }
}
