package com.google.android.gms.internal.cast;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzfw extends zzfl {
    final transient Object zza;

    public zzfw(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzfm(this.zza);
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        return "[" + this.zza.toString() + "]";
    }

    public final int zza(Object[] objArr, int i) {
        objArr[0] = this.zza;
        return 1;
    }

    public final zzfh zzd() {
        Object obj = this.zza;
        int i = zzfh.zzd;
        Object[] objArr = {obj};
        zzfn.zzb(objArr, 1);
        return zzfh.zzi(objArr, 1);
    }

    public final zzfx zze() {
        return new zzfm(this.zza);
    }

    public final boolean zzf() {
        throw null;
    }
}
