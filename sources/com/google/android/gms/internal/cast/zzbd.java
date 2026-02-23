package com.google.android.gms.internal.cast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import o4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzbd implements OnCompleteListener {
    public final /* synthetic */ zzbf zza;
    public final /* synthetic */ c zzb;

    public /* synthetic */ zzbd(zzbf zzbfVar, c cVar) {
        this.zza = zzbfVar;
        this.zzb = cVar;
    }

    public final void onComplete(Task task) {
        this.zza.zzp(this.zzb, task);
    }
}
