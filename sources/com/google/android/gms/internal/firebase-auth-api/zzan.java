package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class zzan extends zzam {
    Object[] zza;
    int zzb;
    boolean zzc;

    public zzan(int i) {
        zzai.zza(4, "initialCapacity");
        this.zza = new Object[4];
        this.zzb = 0;
    }

    public zzan zza(Object obj) {
        zzy.zza(obj);
        int i = this.zzb + 1;
        Object[] objArr = this.zza;
        if (objArr.length >= i) {
            if (this.zzc) {
                this.zza = (Object[]) objArr.clone();
            }
            Object[] objArr2 = this.zza;
            int i2 = this.zzb;
            this.zzb = i2 + 1;
            objArr2[i2] = obj;
            return this;
        }
        this.zza = Arrays.copyOf(objArr, zzam.zza(objArr.length, i));
        this.zzc = false;
        Object[] objArr22 = this.zza;
        int i22 = this.zzb;
        this.zzb = i22 + 1;
        objArr22[i22] = obj;
        return this;
    }
}
