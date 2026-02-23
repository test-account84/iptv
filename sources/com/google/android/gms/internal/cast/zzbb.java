package com.google.android.gms.internal.cast;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.r;
import t.c;
import t4.b;
import u0.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbb implements L.e {
    private static final b zza = new b("MediaRouterOPTListener");
    private final zzbm zzb;
    private final Handler zzc = new zzdy(Looper.getMainLooper());

    public zzbb(zzbm zzbmVar) {
        this.zzb = (zzbm) r.m(zzbmVar);
    }

    public final y5.b onPrepareTransfer(L.h hVar, L.h hVar2) {
        zza.a("Prepare transfer from Route(%s) to Route(%s)", hVar, hVar2);
        return c.a(new zzba(this, hVar, hVar2));
    }

    public final /* synthetic */ Object zza(L.h hVar, L.h hVar2, c.a aVar) throws Exception {
        return Boolean.valueOf(this.zzc.post(new zzaz(this, hVar, hVar2, aVar)));
    }

    public final /* synthetic */ void zzb(L.h hVar, L.h hVar2, c.a aVar) {
        this.zzb.zzl(hVar, hVar2, aVar);
    }
}
