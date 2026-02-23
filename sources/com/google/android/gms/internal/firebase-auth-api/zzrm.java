package com.google.android.gms.internal.firebase-auth-api;

import java.util.Collections;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzrm {
    private HashMap zza = new HashMap();

    public final zzrn zza() {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zzrn zzrnVar = new zzrn(Collections.unmodifiableMap(this.zza), null);
        this.zza = null;
        return zzrnVar;
    }
}
