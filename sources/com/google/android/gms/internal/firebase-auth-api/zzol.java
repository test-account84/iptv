package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzol {
    private final Class zza;
    private final Class zzb;

    private zzol(Class cls, Class cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzol)) {
            return false;
        }
        zzol zzolVar = (zzol) obj;
        return zzolVar.zza.equals(this.zza) && zzolVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return this.zza.getSimpleName() + " with primitive type: " + this.zzb.getSimpleName();
    }

    public /* synthetic */ zzol(Class cls, Class cls2, zzoo zzooVar) {
        this(cls, cls2);
    }
}
