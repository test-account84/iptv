package com.google.android.gms.internal.common;

import java.io.IOException;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzv implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzx zzb;

    public zzv(zzx zzxVar, CharSequence charSequence) {
        this.zzb = zzxVar;
        this.zza = charSequence;
    }

    public final Iterator iterator() {
        return zzx.zze(this.zzb, this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it = iterator();
        try {
            if (it.hasNext()) {
                CharSequence zza = zzq.zza(it.next(), ", ");
                while (true) {
                    sb.append(zza);
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append(", ");
                    zza = zzq.zza(it.next(), ", ");
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
