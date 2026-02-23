package com.google.android.gms.internal.play_billing;

import j$.util.Objects;
import java.util.AbstractMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzap extends zzai {
    final /* synthetic */ zzaq zza;

    public zzap(zzaq zzaqVar) {
        this.zza = zzaqVar;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzaa.zza(i, zzaq.zzi(this.zza), "index");
        int i2 = i + i;
        Object obj = zzaq.zzj(this.zza)[i2];
        Objects.requireNonNull(obj);
        Object obj2 = zzaq.zzj(this.zza)[i2 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return zzaq.zzi(this.zza);
    }

    public final boolean zzf() {
        return true;
    }
}
