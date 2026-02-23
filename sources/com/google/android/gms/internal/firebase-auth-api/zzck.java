package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzck implements Comparable {
    private final byte[] zza;

    private zzck(byte[] bArr) {
        this.zza = Arrays.copyOf(bArr, bArr.length);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        zzck zzckVar = (zzck) obj;
        byte[] bArr = this.zza;
        int length = bArr.length;
        byte[] bArr2 = zzckVar.zza;
        if (length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        int i = 0;
        while (true) {
            byte[] bArr3 = this.zza;
            if (i >= bArr3.length) {
                return 0;
            }
            byte b = bArr3[i];
            byte b2 = zzckVar.zza[i];
            if (b != b2) {
                return b - b2;
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzck) {
            return Arrays.equals(this.zza, ((zzck) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        return zzxj.zza(this.zza);
    }

    public /* synthetic */ zzck(byte[] bArr, zzcn zzcnVar) {
        this(bArr);
    }
}
