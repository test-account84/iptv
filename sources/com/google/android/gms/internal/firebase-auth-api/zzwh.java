package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzwh implements zzbp {
    private static final zzif.zza zza = zzif.zza.zza;
    private static final Collection zzb = Arrays.asList(new Integer[]{64});
    private static final byte[] zzc = new byte[16];
    private static final byte[] zzd = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
    private final zzxl zze;
    private final byte[] zzf;
    private final byte[] zzg;

    public zzwh(byte[] bArr) throws GeneralSecurityException {
        this(bArr, zzxt.zza(new byte[0]));
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zza2;
        int length = bArr.length;
        byte[] bArr3 = this.zzg;
        if (length < bArr3.length + 16) {
            throw new GeneralSecurityException("Ciphertext too short.");
        }
        if (!zzpf.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        Cipher cipher = (Cipher) zzwt.zza.zza("AES/CTR/NoPadding");
        byte[] bArr4 = this.zzg;
        byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr4.length, bArr4.length + 16);
        byte[] bArr5 = (byte[]) copyOfRange.clone();
        bArr5[8] = (byte) (bArr5[8] & Byte.MAX_VALUE);
        bArr5[12] = (byte) (bArr5[12] & Byte.MAX_VALUE);
        cipher.init(2, new SecretKeySpec(this.zzf, "AES"), new IvParameterSpec(bArr5));
        byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zzg.length + 16, bArr.length);
        byte[] doFinal = cipher.doFinal(copyOfRange2);
        if (copyOfRange2.length == 0 && doFinal == null && zzxp.zza()) {
            doFinal = new byte[0];
        }
        byte[][] bArr6 = {bArr2, doFinal};
        byte[] zza3 = this.zze.zza(zzc, 16);
        for (int i = 0; i <= 0; i++) {
            byte[] bArr7 = bArr6[i];
            if (bArr7 == null) {
                bArr7 = new byte[0];
            }
            zza3 = zzwg.zza(zzrd.zzb(zza3), this.zze.zza(bArr7, 16));
        }
        byte[] bArr8 = bArr6[1];
        if (bArr8.length < 16) {
            zza2 = zzwg.zza(zzrd.zza(bArr8), zzrd.zzb(zza3));
        } else {
            if (bArr8.length < zza3.length) {
                throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
            }
            int length2 = bArr8.length - zza3.length;
            zza2 = Arrays.copyOf(bArr8, bArr8.length);
            for (int i2 = 0; i2 < zza3.length; i2++) {
                int i3 = length2 + i2;
                zza2[i3] = (byte) (zza2[i3] ^ zza3[i2]);
            }
        }
        if (MessageDigest.isEqual(copyOfRange, this.zze.zza(zza2, 16))) {
            return doFinal;
        }
        throw new AEADBadTagException("Integrity check failed.");
    }

    private zzwh(byte[] bArr, zzxt zzxtVar) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        if (zzb.contains(Integer.valueOf(bArr.length))) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
            this.zzf = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
            this.zze = new zzxl(copyOfRange);
            this.zzg = zzxtVar.zzb();
            return;
        }
        throw new InvalidKeyException("invalid key size: " + bArr.length + " bytes; key must have 64 bytes");
    }
}
