package com.google.android.gms.internal.firebase-auth-api;

import java.util.AbstractMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzay extends zzap {
    private final /* synthetic */ zzaz zza;

    public zzay(zzaz zzazVar) {
        this.zza = zzazVar;
    }

    public final /* synthetic */ Object get(int i) {
        zzy.zza(i, zzaz.zza(this.zza));
        int i2 = i * 2;
        Object obj = zzaz.zzb(this.zza)[i2];
        obj.getClass();
        Object obj2 = zzaz.zzb(this.zza)[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return zzaz.zza(this.zza);
    }

    public final boolean zze() {
        return true;
    }
}
