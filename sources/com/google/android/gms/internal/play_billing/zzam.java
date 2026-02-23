package com.google.android.gms.internal.play_billing;

import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzam extends zzaf implements Set, j$.util.Set {
    private transient zzai zza;

    public final boolean equals(Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (NullPointerException | ClassCastException unused) {
            }
        }
        return false;
    }

    public final int hashCode() {
        return zzau.zza(this);
    }

    public zzai zzd() {
        zzai zzaiVar = this.zza;
        if (zzaiVar != null) {
            return zzaiVar;
        }
        zzai zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public abstract zzav iterator();

    public zzai zzh() {
        Object[] array = toArray();
        int i = zzai.zzd;
        return zzai.zzi(array, array.length);
    }
}
