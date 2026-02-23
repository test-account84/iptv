package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzio extends zziy {
    public zzio(int i) {
        super(i, null);
    }

    public final void zza() {
        if (!zzj()) {
            for (int i = 0; i < zzb(); i++) {
                ((zzgd) zzg(i).getKey()).zzg();
            }
            Iterator it = zzc().iterator();
            while (it.hasNext()) {
                ((zzgd) ((Map.Entry) it.next()).getKey()).zzg();
            }
        }
        super.zza();
    }
}
