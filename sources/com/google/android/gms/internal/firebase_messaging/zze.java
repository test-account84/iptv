package com.google.android.gms.internal.firebase_messaging;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import r6.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zze {
    private static final zzx zza;

    static {
        zzw zzwVar = new zzw();
        zzd.zza.configure(zzwVar);
        zza = zzwVar.zza();
    }

    private zze() {
    }

    public static void zzb(Object obj, OutputStream outputStream) throws IOException {
        zza.zza(obj, outputStream);
    }

    public static byte[] zzc(Object obj) {
        zzx zzxVar = zza;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            zzxVar.zza(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    public abstract b zza();
}
