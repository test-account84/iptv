package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzhe extends ContentObserver {
    final /* synthetic */ zzhf zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhe(zzhf zzhfVar, Handler handler) {
        super((Handler) null);
        this.zza = zzhfVar;
    }

    public final void onChange(boolean z) {
        this.zza.zzf();
    }
}
