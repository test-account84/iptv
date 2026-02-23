package com.google.android.gms.internal.firebase-auth-api;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzrl implements zzce {
    private static final byte[] zza = {0};
    private final zzce zzb;
    private final zzvs zzc;
    private final byte[] zzd;

    private zzrl(zzce zzceVar, zzvs zzvsVar, byte[] bArr) {
        this.zzb = zzceVar;
        this.zzc = zzvsVar;
        this.zzd = bArr;
    }

    public static zzce zza(zznd zzndVar) throws GeneralSecurityException {
        byte[] bArr;
        ByteBuffer put;
        zzos zza2 = zzndVar.zza(zzbq.zza());
        zzce zzceVar = (zzce) zzow.zza().zza((zzuy) ((zzajc) zzuy.zza().zza(zza2.zzf()).zza(zza2.zzd()).zza(zza2.zza()).zzf()), zzce.class);
        zzvs zzc = zza2.zzc();
        int i = zzrk.zza[zzc.ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                put = ByteBuffer.allocate(5).put((byte) 0);
            } else {
                if (i != 4) {
                    throw new GeneralSecurityException("unknown output prefix type");
                }
                put = ByteBuffer.allocate(5).put((byte) 1);
            }
            bArr = put.putInt(zzndVar.zza().intValue()).array();
        } else {
            bArr = new byte[0];
        }
        return new zzrl(zzceVar, zzc, bArr);
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 10) {
            throw new GeneralSecurityException("tag too short");
        }
        if (this.zzc.equals(zzvs.zzc)) {
            bArr2 = zzwg.zza(bArr2, zza);
        }
        byte[] bArr3 = new byte[0];
        if (!this.zzc.equals(zzvs.zzd)) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            bArr = Arrays.copyOfRange(bArr, 5, bArr.length);
            bArr3 = copyOf;
        }
        if (!Arrays.equals(this.zzd, bArr3)) {
            throw new GeneralSecurityException("wrong prefix");
        }
        this.zzb.zza(bArr, bArr2);
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        if (this.zzc.equals(zzvs.zzc)) {
            bArr = zzwg.zza(bArr, zza);
        }
        return zzwg.zza(this.zzd, this.zzb.zza(bArr));
    }
}
