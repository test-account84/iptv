package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzpa {
    private final Class zza;
    private final zzxt zzb;

    private zzpa(Class cls, zzxt zzxtVar) {
        this.zza = cls;
        this.zzb = zzxtVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzpa)) {
            return false;
        }
        zzpa zzpaVar = (zzpa) obj;
        return zzpaVar.zza.equals(this.zza) && zzpaVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return this.zza.getSimpleName() + ", object identifier: " + String.valueOf(this.zzb);
    }

    public /* synthetic */ zzpa(Class cls, zzxt zzxtVar, zzoz zzozVar) {
        this(cls, zzxtVar);
    }
}
