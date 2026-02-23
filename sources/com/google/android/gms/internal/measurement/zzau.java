package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzau implements zzap {
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof zzau;
    }

    public final zzap zzbU(String str, zzg zzgVar, List list) {
        throw new IllegalStateException(String.format("Undefined has no function %s", new Object[]{str}));
    }

    public final zzap zzd() {
        return zzap.zzf;
    }

    public final Boolean zzg() {
        return Boolean.FALSE;
    }

    public final Double zzh() {
        return Double.valueOf(Double.NaN);
    }

    public final String zzi() {
        return "undefined";
    }

    public final Iterator zzl() {
        return null;
    }
}
