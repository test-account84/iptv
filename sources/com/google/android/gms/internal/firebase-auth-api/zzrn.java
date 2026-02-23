package com.google.android.gms.internal.firebase-auth-api;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzrn {
    public static final zzrn zza = new zzrm().zza();
    private final Map zzb;

    private zzrn(Map map) {
        this.zzb = map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzrn) {
            return this.zzb.equals(((zzrn) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb.toString();
    }

    public final Map zza() {
        return this.zzb;
    }

    public /* synthetic */ zzrn(Map map, zzrp zzrpVar) {
        this(map);
    }
}
