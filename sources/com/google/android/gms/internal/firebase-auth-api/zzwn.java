package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzwn {
    private ECPrivateKey zza;

    public zzwn(ECPrivateKey eCPrivateKey) {
        this.zza = eCPrivateKey;
    }

    public final byte[] zza(byte[] bArr, String str, byte[] bArr2, byte[] bArr3, int i, zzwr zzwrVar) throws GeneralSecurityException {
        byte[] zza = zzwg.zza(bArr, zzwp.zza(this.zza, zzwp.zza(this.zza.getParams(), zzwrVar, bArr)));
        Mac mac = (Mac) zzwt.zzb.zza(str);
        if (i > mac.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        if (bArr2 == null || bArr2.length == 0) {
            mac.init(new SecretKeySpec(new byte[mac.getMacLength()], str));
        } else {
            mac.init(new SecretKeySpec(bArr2, str));
        }
        byte[] doFinal = mac.doFinal(zza);
        byte[] bArr4 = new byte[i];
        mac.init(new SecretKeySpec(doFinal, str));
        byte[] bArr5 = new byte[0];
        int i2 = 1;
        int i3 = 0;
        while (true) {
            mac.update(bArr5);
            mac.update(bArr3);
            mac.update((byte) i2);
            bArr5 = mac.doFinal();
            if (bArr5.length + i3 >= i) {
                System.arraycopy(bArr5, 0, bArr4, i3, i - i3);
                return bArr4;
            }
            System.arraycopy(bArr5, 0, bArr4, i3, bArr5.length);
            i3 += bArr5.length;
            i2++;
        }
    }
}
