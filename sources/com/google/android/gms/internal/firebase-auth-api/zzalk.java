package com.google.android.gms.internal.firebase-auth-api;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzalk extends zzals {
    private final /* synthetic */ zzalg zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzalk(zzalg zzalgVar) {
        super(zzalgVar, null);
        this.zza = zzalgVar;
    }

    public final Iterator iterator() {
        return new zzali(this.zza, null);
    }

    public /* synthetic */ zzalk(zzalg zzalgVar, zzaln zzalnVar) {
        this(zzalgVar);
    }
}
