package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzrt {
    private ArrayList zza = new ArrayList();
    private zzrn zzb = zzrn.zza;
    private Integer zzc = null;

    public final zzrq zza() throws GeneralSecurityException {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        Integer num = this.zzc;
        if (num != null) {
            int intValue = num.intValue();
            ArrayList arrayList = this.zza;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                if (((zzrs) obj).zza() == intValue) {
                }
            }
            throw new GeneralSecurityException("primary key ID is not present in entries");
        }
        zzrq zzrqVar = new zzrq(this.zzb, Collections.unmodifiableList(this.zza), this.zzc, null);
        this.zza = null;
        return zzrqVar;
    }

    public final zzrt zza(int i) {
        if (this.zza == null) {
            throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
        }
        this.zzc = Integer.valueOf(i);
        return this;
    }

    public final zzrt zza(zzbv zzbvVar, int i, String str, String str2) {
        ArrayList arrayList = this.zza;
        if (arrayList == null) {
            throw new IllegalStateException("addEntry cannot be called after build()");
        }
        arrayList.add(new zzrs(zzbvVar, i, str, str2, null));
        return this;
    }

    public final zzrt zza(zzrn zzrnVar) {
        if (this.zza == null) {
            throw new IllegalStateException("setAnnotations cannot be called after build()");
        }
        this.zzb = zzrnVar;
        return this;
    }
}
