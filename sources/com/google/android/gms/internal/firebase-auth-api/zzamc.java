package com.google.android.gms.internal.firebase-auth-api;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzamc extends RuntimeException {
    private final List zza;

    public zzamc(zzakn zzaknVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zza = null;
    }

    public final zzaji zza() {
        return new zzaji(getMessage());
    }
}
