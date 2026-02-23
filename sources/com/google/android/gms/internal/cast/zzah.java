package com.google.android.gms.internal.cast;

import android.content.Context;
import n4.f;
import o4.c;
import o4.e;
import o4.w;
import o4.z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzah extends z {
    private final c zza;
    private final zzbf zzb;

    public zzah(Context context, c cVar, zzbf zzbfVar) {
        super(context, cVar.N().isEmpty() ? f.a(cVar.K()) : f.b(cVar.K(), cVar.N()));
        this.zza = cVar;
        this.zzb = zzbfVar;
    }

    public final w createSession(String str) {
        return new e(getContext(), getCategory(), str, this.zza, this.zzb, new q4.w(getContext(), this.zza, this.zzb));
    }

    public final boolean isSessionRecoverable() {
        return this.zza.L();
    }
}
