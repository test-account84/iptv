package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaf extends zzae {
    private final /* synthetic */ zzp zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaf(zzac zzacVar, zzab zzabVar, CharSequence charSequence, zzp zzpVar) {
        super(zzabVar, charSequence);
        this.zzb = zzpVar;
    }

    public final int zza(int i) {
        return this.zzb.zza();
    }

    public final int zzb(int i) {
        if (this.zzb.zza(i)) {
            return this.zzb.zzb();
        }
        return -1;
    }
}
