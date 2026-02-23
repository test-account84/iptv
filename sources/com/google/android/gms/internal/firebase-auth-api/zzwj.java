package com.google.android.gms.internal.firebase-auth-api;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzwj implements zzbg {
    private final zzhx zza;
    private final byte[] zzb;

    public zzwj(byte[] bArr) throws GeneralSecurityException {
        this(bArr, new byte[0]);
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] copyOf = Arrays.copyOf(bArr, 12);
        return this.zza.zza(ByteBuffer.wrap(bArr, 12, bArr.length - 12), copyOf, bArr2);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return zzc(bArr, bArr2);
        }
        if (zzpf.zza(bArr3, bArr)) {
            return zzc(Arrays.copyOfRange(bArr, this.zzb.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 28);
        byte[] zza = zzou.zza(12);
        allocate.put(zza);
        this.zza.zza(allocate, zza, bArr, bArr2);
        byte[] array = allocate.array();
        byte[] bArr3 = this.zzb;
        return bArr3.length == 0 ? array : zzwg.zza(bArr3, array);
    }

    private zzwj(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        this.zza = new zzhx(bArr);
        this.zzb = bArr2;
    }
}
