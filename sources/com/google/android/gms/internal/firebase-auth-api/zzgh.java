package com.google.android.gms.internal.firebase-auth-api;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzgh implements zzbg {
    private static final byte[] zza = new byte[0];
    private static final Set zzb;
    private final zzvb zzc;
    private final zzbg zzd;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = Collections.unmodifiableSet(hashSet);
    }

    @Deprecated
    public zzgh(zzvb zzvbVar, zzbg zzbgVar) {
        if (zza(zzvbVar.zzf())) {
            this.zzc = zzvbVar;
            this.zzd = zzbgVar;
        } else {
            throw new IllegalArgumentException("Unsupported DEK key type: " + zzvbVar.zzf() + ". Only Tink AEAD key types are supported.");
        }
    }

    public static boolean zza(String str) {
        return zzb.contains(str);
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzg = zzct.zza(this.zzc).zze().zzg();
        byte[] zzb2 = this.zzd.zzb(zzg, zza);
        byte[] zzb3 = ((zzbg) zzct.zza(this.zzc.zzf(), zzg, zzbg.class)).zzb(bArr, bArr2);
        return ByteBuffer.allocate(zzb2.length + 4 + zzb3.length).putInt(zzb2.length).put(zzb2).put(zzb3).array();
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i = wrap.getInt();
            if (i <= 0 || i > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i];
            wrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[wrap.remaining()];
            wrap.get(bArr4, 0, wrap.remaining());
            return ((zzbg) zzct.zza(this.zzc.zzf(), this.zzd.zza(bArr3, zza), zzbg.class)).zza(bArr4, bArr2);
        } catch (NegativeArraySizeException e) {
            e = e;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (BufferUnderflowException e2) {
            e = e2;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (IndexOutOfBoundsException e3) {
            e = e3;
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }
}
