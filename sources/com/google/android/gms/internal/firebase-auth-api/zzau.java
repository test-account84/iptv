package com.google.android.gms.internal.firebase-auth-api;

import java.util.Iterator;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzau extends zzak implements Set, j$.util.Set {
    private transient zzap zza;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return zzbd.zza(this, obj);
    }

    public int hashCode() {
        return zzbd.zza(this);
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public zzap zzc() {
        zzap zzapVar = this.zza;
        if (zzapVar != null) {
            return zzapVar;
        }
        zzap zzg = zzg();
        this.zza = zzg;
        return zzg;
    }

    public zzap zzg() {
        return zzap.zza(toArray());
    }
}
