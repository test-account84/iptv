package com.google.android.gms.internal.firebase-auth-api;

import android.util.Log;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.ProviderException;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzmb implements zzbg {
    private static final String zza = "zzmb";
    private final SecretKey zzb;

    public zzmb(String str, KeyStore keyStore) throws GeneralSecurityException {
        SecretKey key = keyStore.getKey(str, (char[]) null);
        this.zzb = key;
        if (key != null) {
            return;
        }
        throw new InvalidKeyException("Keystore cannot load the key with ID: " + str);
    }

    private static void zza() {
        try {
            Thread.sleep((int) (Math.random() * 100.0d));
        } catch (InterruptedException unused) {
        }
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr, 0, 12);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, this.zzb, gCMParameterSpec);
        cipher.updateAAD(bArr2);
        return cipher.doFinal(bArr, 12, bArr.length - 12);
    }

    private final byte[] zzd(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + 28];
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, this.zzb);
        cipher.updateAAD(bArr2);
        cipher.doFinal(bArr, 0, bArr.length, bArr3, 12);
        System.arraycopy(cipher.getIV(), 0, bArr3, 0, 12);
        return bArr3;
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            return zzd(bArr, bArr2);
        } catch (GeneralSecurityException | ProviderException e) {
            Log.w(zza, "encountered a potentially transient KeyStore error, will wait and retry", e);
            zza();
            return zzd(bArr, bArr2);
        }
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        try {
            return zzc(bArr, bArr2);
        } catch (ProviderException e) {
            e = e;
            Log.w(zza, "encountered a potentially transient KeyStore error, will wait and retry", e);
            zza();
            return zzc(bArr, bArr2);
        } catch (AEADBadTagException e2) {
            throw e2;
        } catch (GeneralSecurityException e3) {
            e = e3;
            Log.w(zza, "encountered a potentially transient KeyStore error, will wait and retry", e);
            zza();
            return zzc(bArr, bArr2);
        }
    }
}
