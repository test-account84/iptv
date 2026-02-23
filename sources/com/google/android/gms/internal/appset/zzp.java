package com.google.android.gms.internal.appset;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import i4.b;
import i4.h;
import w4.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzp extends e implements b {
    private static final a.g zza;
    private static final a.a zzb;
    private static final a zzc;
    private final Context zzd;
    private final i zze;

    static {
        a.g gVar = new a.g();
        zza = gVar;
        zzn zznVar = new zzn();
        zzb = zznVar;
        zzc = new a("AppSet.API", zznVar, gVar);
    }

    public zzp(Context context, i iVar) {
        super(context, zzc, a.d.a, e.a.c);
        this.zzd = context;
        this.zze = iVar;
    }

    public final Task getAppSetIdInfo() {
        return this.zze.j(this.zzd, 212800000) == 0 ? doRead(t.a().d(h.a).b(new zzm(this)).c(false).e(27601).a()) : Tasks.forException(new com.google.android.gms.common.api.b(new Status(17)));
    }
}
