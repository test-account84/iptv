package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzgz extends ContentObserver {
    public zzgz(Handler handler) {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        zzha.zzb().set(true);
    }
}
