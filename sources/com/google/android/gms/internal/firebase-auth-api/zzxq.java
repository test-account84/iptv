package com.google.android.gms.internal.firebase-auth-api;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzxq implements zzbg {
    private final zzic zza;
    private final byte[] zzb;

    public zzxq(byte[] bArr) throws GeneralSecurityException {
        this(bArr, new byte[0]);
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 40) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] copyOf = Arrays.copyOf(bArr, 24);
        return this.zza.zza(ByteBuffer.wrap(bArr, 24, bArr.length - 24), copyOf, bArr2);
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
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 40);
        byte[] zza = zzou.zza(24);
        allocate.put(zza);
        this.zza.zza(allocate, zza, bArr, bArr2);
        byte[] array = allocate.array();
        byte[] bArr3 = this.zzb;
        return bArr3.length == 0 ? array : zzwg.zza(bArr3, array);
    }

    private zzxq(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        this.zza = new zzic(bArr);
        this.zzb = bArr2;
    }
}
