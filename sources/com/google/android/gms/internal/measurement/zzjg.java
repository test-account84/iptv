package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzjg extends zzjb {
    final transient Object zza;

    public zzjg(Object obj) {
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
        return new zzjc(this.zza);
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

    public final zzjh zzd() {
        return new zzjc(this.zza);
    }
}
