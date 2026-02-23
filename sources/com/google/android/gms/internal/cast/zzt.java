package com.google.android.gms.internal.cast;

import android.view.View;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzt implements View.OnClickListener {
    final /* synthetic */ zzy zza;

    public zzt(zzy zzyVar) {
        this.zza = zzyVar;
    }

    public final void onClick(View view) {
        Iterator it = zzy.zza(this.zza).iterator();
        while (it.hasNext()) {
            ((zzv) it.next()).zze();
        }
    }
}
