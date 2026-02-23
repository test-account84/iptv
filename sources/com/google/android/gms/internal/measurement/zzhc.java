package com.google.android.gms.internal.measurement;

import android.content.Context;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzhc extends zzhz {
    private final Context zza;
    private final zzim zzb;

    public zzhc(Context context, zzim zzimVar) {
        this.zza = context;
        this.zzb = zzimVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzhz) {
            zzhz zzhzVar = (zzhz) obj;
            if (this.zza.equals(zzhzVar.zza())) {
                zzim zzimVar = this.zzb;
                zzim zzb = zzhzVar.zzb();
                if (zzimVar != null ? zzimVar.equals(zzb) : zzb == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zza.hashCode() ^ 1000003;
        zzim zzimVar = this.zzb;
        return (hashCode * 1000003) ^ (zzimVar == null ? 0 : zzimVar.hashCode());
    }

    public final String toString() {
        return "FlagsContext{context=" + this.zza.toString() + ", hermeticFileOverrides=" + String.valueOf(this.zzb) + "}";
    }

    public final Context zza() {
        return this.zza;
    }

    public final zzim zzb() {
        return this.zzb;
    }
}
