package com.google.android.gms.internal.cast;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzfe extends zzfb {
    public zzfe() {
        super(4);
    }

    public final zzfe zzb(Object obj) {
        obj.getClass();
        int i = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length >= i) {
            if (this.zzc) {
                this.zza = (Object[]) objArr.clone();
            }
            Object[] objArr2 = this.zza;
            int i2 = this.zzb;
            this.zzb = i2 + 1;
            objArr2[i2] = obj;
            return this;
        }
        this.zza = Arrays.copyOf(objArr, zzfc.zza(length, i));
        this.zzc = false;
        Object[] objArr22 = this.zza;
        int i22 = this.zzb;
        this.zzb = i22 + 1;
        objArr22[i22] = obj;
        return this;
    }

    public final zzfh zzc() {
        this.zzc = true;
        return zzfh.zzi(this.zza, this.zzb);
    }
}
