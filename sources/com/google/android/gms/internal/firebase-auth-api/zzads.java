package com.google.android.gms.internal.firebase-auth-api;

import A5.m;
import G5.F;
import G5.G;
import G5.H;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzads extends H {
    private final /* synthetic */ H zza;
    private final /* synthetic */ String zzb;

    public zzads(H h, String str) {
        this.zza = h;
        this.zzb = str;
    }

    public final void onCodeAutoRetrievalTimeOut(String str) {
        zzadt.zza(this.zzb);
        this.zza.onCodeAutoRetrievalTimeOut(str);
    }

    public final void onCodeSent(String str, G g) {
        this.zza.onCodeSent(str, g);
    }

    public final void onVerificationCompleted(F f) {
        zzadt.zza(this.zzb);
        this.zza.onVerificationCompleted(f);
    }

    public final void onVerificationFailed(m mVar) {
        zzadt.zza(this.zzb);
        this.zza.onVerificationFailed(mVar);
    }
}
