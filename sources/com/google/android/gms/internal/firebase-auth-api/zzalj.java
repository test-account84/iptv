package com.google.android.gms.internal.firebase-auth-api;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzalj extends zzalg {
    public zzalj(int i) {
        super(i, null);
    }

    public final void zzd() {
        if (!zze()) {
            for (int i = 0; i < zza(); i++) {
                Map.Entry zzb = zzb(i);
                if (((zzaix) zzb.getKey()).zze()) {
                    zzb.setValue(Collections.unmodifiableList((List) zzb.getValue()));
                }
            }
            for (Map.Entry entry : zzb()) {
                if (((zzaix) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzd();
    }
}
