package com.google.android.gms.internal.cast;

import java.util.AbstractMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzfp extends zzfh {
    final /* synthetic */ zzfq zza;

    public zzfp(zzfq zzfqVar) {
        this.zza = zzfqVar;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzeu.zza(i, zzfq.zzm(this.zza), "index");
        zzfq zzfqVar = this.zza;
        int i2 = i + i;
        Object obj = zzfq.zzn(zzfqVar)[i2];
        obj.getClass();
        Object obj2 = zzfq.zzn(zzfqVar)[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return zzfq.zzm(this.zza);
    }

    public final boolean zzf() {
        return true;
    }
}
