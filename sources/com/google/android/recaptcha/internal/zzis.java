package com.google.android.recaptcha.internal;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzis implements Map.Entry, Comparable {
    final /* synthetic */ zziy zza;
    private final Comparable zzb;
    private Object zzc;

    public zzis(zziy zziyVar, Comparable comparable, Object obj) {
        this.zza = zziyVar;
        this.zzb = comparable;
        this.zzc = obj;
    }

    private static final boolean zzb(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzb.compareTo(((zzis) obj).zzb);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return zzb(this.zzb, entry.getKey()) && zzb(this.zzc, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.zzb;
    }

    public final Object getValue() {
        return this.zzc;
    }

    public final int hashCode() {
        Comparable comparable = this.zzb;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.zzc;
        return hashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    public final Object setValue(Object obj) {
        zziy.zzi(this.zza);
        Object obj2 = this.zzc;
        this.zzc = obj;
        return obj2;
    }

    public final String toString() {
        return String.valueOf(this.zzb) + "=" + String.valueOf(this.zzc);
    }

    public final Comparable zza() {
        return this.zzb;
    }
}
