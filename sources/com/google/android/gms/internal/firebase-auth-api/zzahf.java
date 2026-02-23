package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzahf implements zzakn {
    protected int zza = 0;

    public int a_() {
        throw new UnsupportedOperationException();
    }

    public int zza(zzalf zzalfVar) {
        int a_ = a_();
        if (a_ != -1) {
            return a_;
        }
        int zza = zzalfVar.zza(this);
        zzb(zza);
        return zza;
    }

    public void zzb(int i) {
        throw new UnsupportedOperationException();
    }

    public final zzahp zzi() {
        try {
            zzahu zzc = zzahp.zzc(zzl());
            zza(zzc.zzb());
            return zzc.zza();
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final byte[] zzj() {
        try {
            byte[] bArr = new byte[zzl()];
            zzaik zzb = zzaik.zzb(bArr);
            zza(zzb);
            zzb.zzb();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }

    public final void zza(OutputStream outputStream) throws IOException {
        zzaik zza = zzaik.zza(outputStream, zzaik.zzf(zzl()));
        zza(zza);
        zza.zzc();
    }
}
