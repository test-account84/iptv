package com.google.android.gms.internal.firebase-auth-api;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzalr implements Comparable, Map.Entry {
    private final Comparable zza;
    private Object zzb;
    private final /* synthetic */ zzalg zzc;

    public zzalr(zzalg zzalgVar, Comparable comparable, Object obj) {
        this.zzc = zzalgVar;
        this.zza = comparable;
        this.zzb = obj;
    }

    private static boolean zza(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzalr) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return zza(this.zza, entry.getKey()) && zza(this.zzb, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.zza;
    }

    public final Object getValue() {
        return this.zzb;
    }

    public final int hashCode() {
        Comparable comparable = this.zza;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.zzb;
        return hashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    public final Object setValue(Object obj) {
        zzalg.zzd(this.zzc);
        Object obj2 = this.zzb;
        this.zzb = obj;
        return obj2;
    }

    public final String toString() {
        return String.valueOf(this.zza) + "=" + String.valueOf(this.zzb);
    }

    public zzalr(zzalg zzalgVar, Map.Entry entry) {
        this(zzalgVar, (Comparable) entry.getKey(), entry.getValue());
    }
}
