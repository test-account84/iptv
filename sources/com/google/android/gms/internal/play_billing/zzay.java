package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzay implements zzec {
    protected int zza = 0;

    public int zza(zzeo zzeoVar) {
        throw null;
    }

    public final zzbq zzb() {
        try {
            int zzf = zzf();
            zzbq zzbqVar = zzbq.zzb;
            byte[] bArr = new byte[zzf];
            zzby zzy = zzby.zzy(bArr, 0, zzf);
            zze(zzy);
            zzy.zzz();
            return new zzbn(bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final byte[] zzc() {
        try {
            int zzf = zzf();
            byte[] bArr = new byte[zzf];
            zzby zzy = zzby.zzy(bArr, 0, zzf);
            zze(zzy);
            zzy.zzz();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
