package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzrq {
    private final zzrn zza;
    private final List zzb;
    private final Integer zzc;

    private zzrq(zzrn zzrnVar, List list, Integer num) {
        this.zza = zzrnVar;
        this.zzb = list;
        this.zzc = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzrq)) {
            return false;
        }
        zzrq zzrqVar = (zzrq) obj;
        if (this.zza.equals(zzrqVar.zza) && this.zzb.equals(zzrqVar.zzb)) {
            Integer num = this.zzc;
            Integer num2 = zzrqVar.zzc;
            if (num == num2) {
                return true;
            }
            if (num != null && num.equals(num2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", new Object[]{this.zza, this.zzb, this.zzc});
    }

    public /* synthetic */ zzrq(zzrn zzrnVar, List list, Integer num, zzru zzruVar) {
        this(zzrnVar, list, num);
    }
}
