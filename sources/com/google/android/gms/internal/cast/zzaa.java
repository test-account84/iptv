package com.google.android.gms.internal.cast;

import androidx.mediarouter.app.b;
import androidx.mediarouter.app.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzaa extends e {
    private static zzaa zza;

    public zzaa() {
        zzr.zzd(zzln.zzac);
    }

    public static zzaa zza() {
        if (zza == null) {
            zza = new zzaa();
        }
        return zza;
    }

    public final b onCreateChooserDialogFragment() {
        return new zzz();
    }
}
