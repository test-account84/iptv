package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzxk implements zzrx {
    private static final zzif.zza zza = zzif.zza.zzb;
    private final ThreadLocal zzb;
    private final String zzc;
    private final Key zzd;
    private final int zze;

    public zzxk(String str, Key key) throws GeneralSecurityException {
        int i;
        zzxn zzxnVar = new zzxn(this);
        this.zzb = zzxnVar;
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.zzc = str;
        this.zzd = key;
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        str.hashCode();
        switch (str) {
            case "HMACSHA1":
                i = 20;
                break;
            case "HMACSHA224":
                i = 28;
                break;
            case "HMACSHA256":
                i = 32;
                break;
            case "HMACSHA384":
                i = 48;
                break;
            case "HMACSHA512":
                i = 64;
                break;
            default:
                throw new NoSuchAlgorithmException("unknown Hmac algorithm: " + str);
        }
        this.zze = i;
        zzxnVar.get();
    }

    public static /* bridge */ /* synthetic */ String zza(zzxk zzxkVar) {
        return zzxkVar.zzc;
    }

    public static /* bridge */ /* synthetic */ Key zzb(zzxk zzxkVar) {
        return zzxkVar.zzd;
    }

    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        if (i > this.zze) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        ((Mac) this.zzb.get()).update(bArr);
        return Arrays.copyOf(((Mac) this.zzb.get()).doFinal(), i);
    }
}
