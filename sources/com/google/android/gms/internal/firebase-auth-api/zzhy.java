package com.google.android.gms.internal.firebase-auth-api;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class zzhy {
    int[] zza;
    private final int zzb;

    public zzhy(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.zza = zzhu.zza(bArr);
        this.zzb = i;
    }

    public abstract int zza();

    public final ByteBuffer zza(byte[] bArr, int i) {
        int[] zza = zza(zzhu.zza(bArr), i);
        int[] iArr = (int[]) zza.clone();
        zzhu.zza(iArr);
        for (int i2 = 0; i2 < zza.length; i2++) {
            zza[i2] = zza[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(zza, 0, 16);
        return order;
    }

    public abstract int[] zza(int[] iArr, int i);

    public void zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() < bArr2.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        zza(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
    }

    private final void zza(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        if (bArr.length != zza()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + zza());
        }
        int remaining = byteBuffer2.remaining();
        int i = remaining / 64;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            ByteBuffer zza = zza(bArr, this.zzb + i3);
            int i4 = 64;
            if (i3 == i) {
                i4 = remaining % 64;
            }
            zzwg.zza(byteBuffer, byteBuffer2, zza, i4);
        }
    }

    public byte[] zza(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        zza(bArr, allocate, byteBuffer);
        return allocate.array();
    }
}
