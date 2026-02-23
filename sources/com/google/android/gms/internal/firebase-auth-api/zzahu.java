package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzahu {
    private final zzaik zza;
    private final byte[] zzb;

    private zzahu(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzaik.zzb(bArr);
    }

    public final zzahp zza() {
        this.zza.zzb();
        return new zzahz(this.zzb);
    }

    public final zzaik zzb() {
        return this.zza;
    }

    public /* synthetic */ zzahu(int i, zzahx zzahxVar) {
        this(i);
    }
}
