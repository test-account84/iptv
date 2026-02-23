package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzir {
    public static zzim zza(zzim zzimVar) {
        return ((zzimVar instanceof zzip) || (zzimVar instanceof zzin)) ? zzimVar : zzimVar instanceof Serializable ? new zzin(zzimVar) : new zzip(zzimVar);
    }

    public static zzim zzb(Object obj) {
        return new zziq(obj);
    }
}
