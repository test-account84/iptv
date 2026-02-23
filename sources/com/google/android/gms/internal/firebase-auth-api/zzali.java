package com.google.android.gms.internal.firebase-auth-api;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzali implements Iterator {
    private int zza;
    private Iterator zzb;
    private final /* synthetic */ zzalg zzc;

    private zzali(zzalg zzalgVar) {
        this.zzc = zzalgVar;
        this.zza = zzalg.zza(zzalgVar).size();
    }

    private final Iterator zza() {
        if (this.zzb == null) {
            this.zzb = zzalg.zzc(this.zzc).entrySet().iterator();
        }
        return this.zzb;
    }

    public final boolean hasNext() {
        int i = this.zza;
        return (i > 0 && i <= zzalg.zza(this.zzc).size()) || zza().hasNext();
    }

    public final /* synthetic */ Object next() {
        Object obj;
        if (zza().hasNext()) {
            obj = zza().next();
        } else {
            List zza = zzalg.zza(this.zzc);
            int i = this.zza - 1;
            this.zza = i;
            obj = zza.get(i);
        }
        return (Map.Entry) obj;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ zzali(zzalg zzalgVar, zzall zzallVar) {
        this(zzalgVar);
    }
}
