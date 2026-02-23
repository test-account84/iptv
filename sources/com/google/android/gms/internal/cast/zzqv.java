package com.google.android.gms.internal.cast;

import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzqv extends zzqo {
    final /* synthetic */ zzqw zza;
    private final Callable zzb;

    public zzqv(zzqw zzqwVar, Callable callable) {
        this.zza = zzqwVar;
        callable.getClass();
        this.zzb = callable;
    }

    public final Object zza() throws Exception {
        return this.zzb.call();
    }

    public final String zzb() {
        return this.zzb.toString();
    }

    public final void zzc(Throwable th) {
        this.zza.zzl(th);
    }

    public final void zzd(Object obj) {
        this.zza.zzk(obj);
    }

    public final boolean zzf() {
        return this.zza.isDone();
    }
}
