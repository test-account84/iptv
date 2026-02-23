package com.google.android.gms.internal.cast;

import java.io.IOException;
import z2.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zze implements e {
    public static final /* synthetic */ zze zza = new zze();

    private /* synthetic */ zze() {
    }

    public final Object apply(Object obj) {
        zzmq zzmqVar = (zzmq) obj;
        try {
            int zzt = zzmqVar.zzt();
            byte[] bArr = new byte[zzt];
            zzru zzz = zzru.zzz(bArr, 0, zzt);
            zzmqVar.zzI(zzz);
            zzz.zzA();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + zzmqVar.getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
