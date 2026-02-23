package com.google.android.gms.internal.cast;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzqz implements zztp {
    protected int zza = 0;

    public int zzp(zzua zzuaVar) {
        throw null;
    }

    public final zzrm zzq() {
        try {
            int zzt = zzt();
            zzrm zzrmVar = zzrm.zzb;
            byte[] bArr = new byte[zzt];
            zzru zzz = zzru.zzz(bArr, 0, zzt);
            zzI(zzz);
            zzz.zzA();
            return new zzrj(bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }
}
