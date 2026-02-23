package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.tasks.OnFailureListener;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzadw implements OnFailureListener {
    public zzadw(zzadu zzaduVar) {
    }

    public final void onFailure(Exception exc) {
        zzadu.zza().c("SmsRetrieverClient failed to start: " + exc.getMessage(), new Object[0]);
    }
}
