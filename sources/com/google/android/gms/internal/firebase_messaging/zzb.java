package com.google.android.gms.internal.firebase_messaging;

import c6.d;
import c6.e;
import c6.f;
import java.io.IOException;
import r6.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzb implements e {
    static final zzb zza = new zzb();
    private static final d zzb;

    static {
        d.b a = d.a("messagingClientEvent");
        zzo zzoVar = new zzo();
        zzoVar.zza(1);
        zzb = a.b(zzoVar.zzb()).a();
    }

    private zzb() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        ((f) obj2).add(zzb, ((b) obj).a());
    }
}
