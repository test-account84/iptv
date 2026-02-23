package com.google.android.recaptcha.internal;

import k8.q;
import kotlin.jvm.internal.m;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzau extends m implements p {
    final /* synthetic */ zzba zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzau(zzba zzbaVar, String str, int i) {
        super(2);
        this.zza = zzbaVar;
        this.zzb = str;
        this.zzc = i;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        zzba.zzg(this.zza, this.zzb, (String) obj2);
        int i = this.zzc;
        if (i != -1) {
            this.zza.zzb().zzb().zzf(i, objArr);
        }
        return q.a;
    }
}
