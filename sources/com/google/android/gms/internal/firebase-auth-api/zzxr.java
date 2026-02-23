package com.google.android.gms.internal.firebase-auth-api;

import java.security.InvalidKeyException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzxr {
    public static byte[] zza(byte[] bArr) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        byte[] bArr2 = new byte[32];
        bArr2[0] = 9;
        return zza(bArr, bArr2);
    }

    public static byte[] zza(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        long[] jArr = new long[11];
        byte[] copyOf = Arrays.copyOf(bArr, 32);
        copyOf[0] = (byte) (copyOf[0] & 248);
        byte b = (byte) (copyOf[31] & Byte.MAX_VALUE);
        copyOf[31] = b;
        copyOf[31] = (byte) (b | 64);
        zzmh.zza(jArr, copyOf, bArr2);
        return zzmm.zzc(jArr);
    }
}
