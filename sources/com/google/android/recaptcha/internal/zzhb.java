package com.google.android.recaptcha.internal;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzhb implements Map.Entry {
    private final Map.Entry zza;

    public /* synthetic */ zzhb(Map.Entry entry, zzha zzhaVar) {
        this.zza = entry;
    }

    public final Object getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        if (((zzhd) this.zza.getValue()) == null) {
            return null;
        }
        throw null;
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzhy) {
            return ((zzhd) this.zza.getValue()).zzc((zzhy) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzhd zza() {
        return (zzhd) this.zza.getValue();
    }
}
