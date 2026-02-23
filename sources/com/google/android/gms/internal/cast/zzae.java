package com.google.android.gms.internal.cast;

import F4.a;
import F4.b;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import o4.q0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzae extends q0 {

    @VisibleForTesting
    public final Set zza = Collections.synchronizedSet(new HashSet());

    public final a zzb() {
        return b.Z(this);
    }

    public final void zzc() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzad) it.next()).zza();
        }
    }

    public final void zzd() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzad) it.next()).zzb();
        }
    }

    public final void zze(zzad zzadVar) {
        this.zza.add(zzadVar);
    }
}
