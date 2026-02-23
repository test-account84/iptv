package com.google.android.gms.internal.firebase_messaging;

import c6.c;
import c6.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzv implements e {
    public static final /* synthetic */ zzv zza = new zzv();

    private /* synthetic */ zzv() {
    }

    public final void encode(Object obj, Object obj2) {
        int i = zzw.zza;
        String valueOf = String.valueOf(obj.getClass().getCanonicalName());
        throw new c(valueOf.length() != 0 ? "Couldn't find encoder for type ".concat(valueOf) : new String("Couldn't find encoder for type "));
    }
}
